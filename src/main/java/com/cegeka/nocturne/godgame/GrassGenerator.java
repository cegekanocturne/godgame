package com.cegeka.nocturne.godgame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

	public IntPair generateUnoccupiedPosition(World world) {
		int emptyCount = countUnocuppiedCells(world);
		if (emptyCount == 0) {
			return null;
		}
		
		int randomChoice = 1 + (new Random()).nextInt(emptyCount);
		
		int count = 0;
		for ( int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				if (world.getCell(i, j) == null) {
					count++;
					if (count == randomChoice) {
						return new IntPair(i, j);
					}
				}
			}
		}
		
		return null;
	}
}
