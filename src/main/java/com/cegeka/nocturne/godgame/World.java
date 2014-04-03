package com.cegeka.nocturne.godgame;

import java.util.ArrayList;
import java.util.List;

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

        // increment age of each creature
        for ( Creature[] row : cells ) {
            for ( Creature creature : row) {
                if ( creature != null ) {
                    creature.incrementAge();
                }
            }
        }
        // each 7 seven days new grass appears in empty spots (STR-4)
        if(this.daysCounter % 7 == 0)
            this.generateGrass();
        // grass expands (STR-5)
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

    public void generateGrass() {
           List<Position> freeCells = this.getFreeCells();
           Position randFreeCell = freeCells.get((int) Math.round(Math.random() * freeCells.size()));

           this.setCell(new Grass(), randFreeCell.x, randFreeCell.y);
    }

    public List<Position> getFreeCells() {
        List<Position> result = new ArrayList<Position>();
        for(int x=0; x< this.size; x++)
            for(int y=0; y< this.size; y++){
                if(this.getCell(x,y) == null){
                    result.add(new Position(x,y));
                }
            }

        return result;
    }

    private class Position{
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
