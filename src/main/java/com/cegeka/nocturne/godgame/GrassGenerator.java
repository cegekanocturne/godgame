package com.cegeka.nocturne.godgame;

import java.util.Random;

public class GrassGenerator {
	public static final Random randomGenerator = new Random();
	
	public static boolean generateAndAddToWorld(int age, World world) {
		if (world == null) {
			return false;
		}
		
		if (age <= 0 || age % 7 != 0) {
			return false;
		}

		IntPair newPosition = generateUnoccupiedPosition(world);
		world.setCell(new GrassCreature(), newPosition.getI(),
				newPosition.getJ());

		return true;
	}

	/* -1 as error value */
	public static int countUnocuppiedCells(World world) {
		int count = 0;

		if (world == null) {
			return -1;
		}

		for (int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				if (world.getCell(i, j) == null) {
					count++;
				}
			}
		}

		return count;
	}
	
	/* null as error value */
	public static IntPair generateUnoccupiedPosition(World world) {
		IntPair result = null;
		
		if (world == null) {
			return null;
		}
		
		int emptyCount = countUnocuppiedCells(world);
		if (emptyCount == 0) {
			return null;
		}

		int randomChoice = 1 + randomGenerator.nextInt(emptyCount); // should start from one
 
		for (int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				if (world.getCell(i, j) == null) {
					randomChoice--;
					
					if (0 == randomChoice) {
						result = new IntPair(i, j);
					}
				}
			}
		}

		return result;
	}
}
