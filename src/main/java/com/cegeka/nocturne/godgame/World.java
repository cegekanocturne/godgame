package com.cegeka.nocturne.godgame;

import java.util.Random;

public class World {
    private final int size;
    private Creature[][] cells = null;
    private int daysCounter;

    public World(int i) {
        if (i <= 0) {
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

        // Creature dieing
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (cells[i][j] != null) {
                    cells[i][j].age();
                    if (cells[i][j].shouldDie()) {
                        cells[i][j] = null;
                    }
                }
            }

        Random r = new Random();

        // new Deer appears
        if (getAge() == 20)
            setCell(new Deer(), r.nextInt(getSize()), r.nextInt(getSize()));

    }

    public int getAge() {
        return daysCounter;
    }

    public int getSize() {
        return size;
    }
}
