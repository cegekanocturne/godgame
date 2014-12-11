package com.cegeka.nocturne.godgame;

import com.cegeka.nocturne.godgame.time.TimerListener;

public class GrassCreature implements Creature, TimerListener {
	private int age;
	
	@Override
	public char getSymbol() {
		return 'G';
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void increaseAgeWithOneDay() {
		age++;
	}

	@Override
	public void dayPassed() {
		increaseAgeWithOneDay();
	}

}
