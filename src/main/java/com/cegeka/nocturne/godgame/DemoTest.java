package com.cegeka.nocturne.godgame;

import java.io.IOException;

import com.cegeka.nocturne.godgame.time.Timer;

public class DemoTest {
	private Timer timer;

	public void pauseGame() {
		System.out.println("Pause game!");
		timer.stop();
	}

	public void resumeGame() {
		System.out.println("Resume game!");
		timer.resume();
	}

	public void doItAll() {
		World world = new World(5);

		Displayer displayer = new Displayer(world);

		timer = new Timer();
		timer.setDayPeriodMs(100);
		timer.addTimerListener(world);
		
		Thread t=new Thread(new Runnable() {
			@Override
			public void run() {
				displayer.display();

				try {
					if (System.in.available() != 0) {
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
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		t.start();
		
		timer.start();

	}

	public static void main(String[] args) {
		new DemoTest().doItAll();
	}

}