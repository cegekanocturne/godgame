package com.cegeka.nocturne.godgame;


import java.util.*;

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
        for ( int i = 0; i < size; i++ ) {
            for ( int j = 0; j < size; j++ ) {
                Creature creature = cells[i][j];
                if ( creature != null ) {
                    creature.incrementAge();
                    if ( creature.getAge() % 7 == 0) {
                        newGrassNearby(i, j);
                    }

                }
            }
        }
        // each 7 seven days new grass appears in empty spots (STR-4)
        if(this.daysCounter % 7 == 0)
            this.generateGrass();
        // grass expands (STR-5)

        toString();
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

    private void newGrassNearby(int x, int y){
        LinkedHashMap<Integer, Integer> emptyCells = new LinkedHashMap<>(8);

        for(int i = x -1; i < x + 1; i++){
            for(int j = y - 1; j < y + 1; j++){
                if(insidePoint(i, j)){
                    if(getCell(i , j) == null){
                        emptyCells.put(i, j);
                    }
                }
            }
        }

        if(emptyCells.size() > 0){
            int index = new Random().nextInt(emptyCells.size()-1);
            Iterator<Integer> iterator = emptyCells.keySet().iterator();
            int k = 0;
            while (iterator.hasNext()){
                int key = iterator.next();
                if(index == k){
                    int value = emptyCells.get(key);
                    setCell(new Grass(), key, value);
                    return;
                }
                k++;
            }
        }
    }

    private boolean insidePoint(int x, int y){
        if(x < 0 || x > size -1){
            return false;
        }
        if(y < 0 || y > size - 1){
            return false;
        }
        return true;
    }
    
    public void generateGrass() {
        List<Position> freeCells = this.getFreeCells();
        Position randFreeCell = freeCells.get((int) Math.round(Math.random() * freeCells.size()) - 1);

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
