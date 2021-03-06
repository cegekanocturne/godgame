package com.cegeka.nocturne.godgame;

import com.cegeka.nocturne.godgame.time.TimerListener;

public class World implements TimerListener{
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
    
    public double getSize() {
        return this.size;
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
                
        for ( int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.cells[i][j] != null) {
					this.cells[i][j].increaseAgeWithOneDay();
				}
			}
		}
        
        GrassGenerator.generateAndAddToWorld(daysCounter, this);
    }

    public int getAge() {
        return daysCounter;
    }

    @Override
    public void dayPassed() {
        passTheDay();
    }
}
