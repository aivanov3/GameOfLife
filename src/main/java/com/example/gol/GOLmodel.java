package com.example.gol;

public class GOLmodel {
    protected int rows;
    protected int cols;

    protected final char ALIVE = '*';
    protected char[][] world;
    public GOLmodel(int r, int c) {
        this.rows = r;
        this.cols = c;
        world = new char[rows][cols];
        putGlider();

        System.out.println("World is rows:"+rows+" cols:"+cols);
    }

    private void putGlider(){
        //x, y
        world[0][2] = '*';
        world[1][0] = '*';
        world[1][2] = '*';
        world[2][1] = '*';
        world[2][2] = '*';
    }

    public char[][] getWorld() {
        return world;
    }

    public Integer checkNeighbors(int row, int col){
        int counter = 0;
        for(int r = row-1; r <= row+1; r++){
            for (int c = col-1; c <= col+1; c++){
                if((r < 0 || c < 0) || (r > this.rows-1 || c > this.cols-1)){
                    //doesn't do anything if r or c is out of bound
                } else {
                    if(world[r][c] == '*' && c != col && r != row){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public void updateWorld(){
        int counter = 0;
        char[][] tempWorld = copyWorld(world);

        for (int c = 0; c < cols; c++){
            for (int r = 0; r < rows; r++){
                counter = checkNeighbors(c, r);

                //birth conditions
                if(counter == 3 && world[c][r] != ALIVE){
                    tempWorld[c][r] = '*';
                    System.out.println("Found 3 spots");
                }
                //alive conditions
                else if((counter == 2 || counter == 3) && world[c][r] == ALIVE){

                }
                //death conditions
                else{
                    tempWorld[c][r] = ' ';
                }

            }
        }
        world = copyWorld(tempWorld);
    }

    public char[][] copyWorld(char[][] tWorld){
        char[][] tempWorld = new char[tWorld.length][tWorld[0].length];
        for (int c = 0; c < tWorld.length; c++){
            for(int r = 0; r < tWorld[0].length; r++){
                tempWorld[c][r] = tWorld[c][r];
            }
        }
        return tempWorld;
    }
}


