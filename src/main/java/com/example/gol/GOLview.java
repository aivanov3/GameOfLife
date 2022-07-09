package com.example.gol;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class GOLview {
    private SimpleIntegerProperty width = new SimpleIntegerProperty(this, "width");
    private SimpleIntegerProperty height = new SimpleIntegerProperty(this, "height");
    private Canvas canvas;
    private GraphicsContext gc;
    private Timeline timeline;
    private int frames;
    private GOLcontroller gol_listener;
    private Stage stage;

    public GOLview(int w, int h){
        width.set(w);
        height.set(h);
    }

    public GOLview(GOLcontroller l, Stage stage){
        width.set(400); //more points - let user select width
        height.set(400); //more points - let user select height
        this.frames = 1;
        this.gol_listener = l; //GOL controller
        this.stage = stage;

        this.canvas = new Canvas(height.get(), width.get());
        gc = canvas.getGraphicsContext2D();

        this.timeline = new Timeline();

        setUpTimeLine();
        setUpStage();
    }



    private void setUpTimeLine(){
        KeyFrame frame = new KeyFrame(Duration.millis(1000/frames), e -> this.render(gc, gol_listener.getWorld()));
        timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    private void setUpStage(){
        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root, this.width.intValue()+100, this.height.intValue()+100);
        stage.setTitle("Game of Life MVC");
        stage.setScene(scene);
        stage.show();
    }


    private void render(GraphicsContext gc, char[][] world) {
        System.out.println("view::render");
        Random random = new Random();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0, width.get(), this.height.get());
        //update world


        for(int i = 0; i < this.height.get(); i++){
            for(int j = 0; j < this.width.get(); j++){
                if(world[i][j] == '*'){
                    gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 1));
                    gc.fillOval(i * 10, j*10, 10, 10);
                }
            }
        }
        gol_listener.updateWorld();
    }

    protected SimpleIntegerProperty getWidth() {
        return width;
    }


    public SimpleIntegerProperty getHeight() {
        return height;
    }
}
