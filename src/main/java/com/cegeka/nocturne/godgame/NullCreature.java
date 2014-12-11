package com.cegeka.nocturne.godgame;

public class NullCreature implements Creature {

	@Override
	public char getSymbol() {
		throw new RuntimeException("Not implemented yet");
	}

	@Override
	public int getAge() {
		throw new RuntimeException("Not implemented yet");
	}

	@Override
	public void increaseAgeWithOneDay() {
		throw new RuntimeException("Not implemented yet");
	}
}
