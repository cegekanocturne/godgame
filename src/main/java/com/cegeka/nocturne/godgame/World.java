package com.cegeka.nocturne.godgame;

public class World {
    private final int size;
    private Creature[][] cells = null;
    private volatile int daysCounter;

    private long startDayTime;

    private boolean paused;

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

    public void start() {
        timePassed();
    }

    private void timePassed() {
        if(!paused) {
            while (true) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - startDayTime < 5 * 1000) {
                    continue;
                }
                daysCounter++;
                startDayTime = currentTime;
            }
        }
    }


    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }

}
