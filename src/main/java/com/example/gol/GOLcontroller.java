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
        
    }

    public char[][] getWorld(){return goLmodel.getWorld();}
}
