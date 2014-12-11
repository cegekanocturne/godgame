package com.cegeka.nocturne.godgame;


public class GrassGenerator {
	public synchronized boolean generateAndAddToWorld (int age, World world) {
		return false;
	}
	
	private int getUnoccupiedPozition() {
		return 0;
	}

	public int countUnocuppiedCells(World world) {
		int count = 0;
		for ( int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				if (world.getCell(i, j) == null) {
					count++;
				}
			}
		}
		
		return count;
	}
}
