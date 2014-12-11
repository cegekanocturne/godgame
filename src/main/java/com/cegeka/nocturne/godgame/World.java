package com.cegeka.nocturne.godgame;

public class World {
    private final int size;
    private Creature[][] cells = null;
    private int daysCounter;


    public World(int i) {
        if(i <= 0) {
            throw new IllegalArgumentException("Size should be bigger than 0.");
        }
        this.size = i;
        cells = new Creature[i][i];
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
}
