package com.example.gol;

import javafx.application.Application;
import javafx.stage.Stage;

public class GOLcontroller extends Application {

    protected GOLmodel goLmodel;
    protected GOLview goLview;
    protected int canvasWidth;
    protected int canvasHeight;
    protected int frames;
    @Override
    public void start(Stage stage) throws Exception {
        this.goLview = new GOLview(this, stage);
        this.goLmodel = new GOLmodel(goLview.getWidth().intValue(), goLview.getHeight().intValue());
    }

    public char[][] getWorld(){return goLmodel.getWorld();}
    public void updateWorld(){goLmodel.updateWorld();}
    public char[][] copyWorld(char[][] world){return goLmodel.copyWorld(world);}
}
