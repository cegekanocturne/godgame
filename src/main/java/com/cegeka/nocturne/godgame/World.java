package com.cegeka.nocturne.godgame;

import java.util.Arrays;

public class World {
    private final int size;
    private Creature[][] cells = null;
    private int daysCounter;


    public World(int worldSize) {
        if(worldSize <= 0) {
            throw new IllegalArgumentException("Size should be bigger than 0.");
        }
        this.size = worldSize;
        cells = new Creature[worldSize][worldSize];
    }

    public double getCellCount() {
        return this.size * this.size;
    }

    public void setCell(Creature creature, int x, int y) {
        cells[x][y] = creature;
    }

    public Creature getCell(int x, int y) {
        return cells[x][y];
    }

    public void passTheDay() {
        this.daysCounter++;
    }

    public int getAge() {
        return daysCounter;
    }

    public void showWorld() {

        System.out.println( "This is the beautiful world:" );
        System.out.println("---------------------------------");
        for(int i=0; i<this.size; i++){
            for (int j=0; j<this.size; j++)
                System.out.format("%s   ",cells[i][j]);
            System.out.println();
        }


    }
}
