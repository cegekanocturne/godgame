package com.cegeka.nocturne.godgame;

import java.util.Arrays;

public class World implements ITimeListener {
    private final int size;
    private Creature[][] cells = null;
    private int daysCounter;
    Time time;

    public World(int i) {
        
        if(i <= 0) {
            throw new IllegalArgumentException("Size should be bigger than 0.");
        }
        this.size = i;		
        cells = new Creature[i][i];
        time = new Time();
        time.registerTimeListener(this);
        time.start();
    }

    public Time getTime() {
        return time;
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

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.size; i++) {
            for (int j=0; j<this.size; j++)
                sb.append(cells[i][j] + " ");
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

}
