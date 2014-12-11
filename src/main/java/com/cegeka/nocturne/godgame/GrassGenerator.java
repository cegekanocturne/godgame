package com.cegeka.nocturne.godgame;

import java.util.Random;

public class GrassGenerator {
	public synchronized static boolean generateAndAddToWorld(int age,
			World world) {
		if (age > 0 && age % 7 == 0) {
			IntPair newPosition = generateUnoccupiedPosition(world);
			world.setCell(new GrassCreature(), newPosition.getI(),
					newPosition.getJ());
			return true;
		}
		return false;
	}

	public static int countUnocuppiedCells(World world) {
		int count = 0;
		for (int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				if (world.getCell(i, j) == null) {
					count++;
				}
			}
		}

		return count;
	}

	public static IntPair generateUnoccupiedPosition(World world) {
		int emptyCount = countUnocuppiedCells(world);
		if (emptyCount == 0) {
			return null;
		}

		int randomChoice = 1 + (new Random()).nextInt(emptyCount);

		int count = 0;
		for (int i = 0; i < world.getSize(); i++) {
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
