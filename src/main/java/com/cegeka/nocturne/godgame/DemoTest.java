package com.cegeka.nocturne.godgame;

import java.io.IOException;

import com.cegeka.nocturne.godgame.time.Timer;
import com.cegeka.nocturne.godgame.time.TimerListener;

public class DemoTest {
	public void pauseGame() {
		
	}
	
	public void resumeGame() {
		
	}
	
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
				
				try {
					char c = (char) System.in.read();
					switch (c) {
					case 'P':
					case 'p':
						pauseGame();
						
						break;
					case 'r':
					case 'R':
						resumeGame();
						break;
					
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		timer.start();
		
		
	}
	
	
	public static void main(String[] args) {
		new DemoTest().doItAll();
	}

}