package com.cegeka.nocturne.godgame;

import com.cegeka.nocturne.godgame.time.Timer;
import com.cegeka.nocturne.godgame.time.TimerListener;

public class DemoTest {
	public void doItAll() {
		World world=new World(5);
		
		Displayer displayer=new Displayer(world);
		
		Timer timer=new Timer();
		timer.setDayPeriodMs(100);
		timer.addTimerListener(world);
		timer.addTimerListener(new TimerListener() {
			
			@Override
			public void dayPassed() {
				displayer.display();
			}
		});
		
		timer.start();
		
		
	}
	
	
	public static void main(String[] args) {
		new DemoTest().doItAll();
	}

}