package com.cegeka.nocturne.godgame.time;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Timer implements TimerInterface {

	private List<TimerListener> timerListeners = new ArrayList<>();

	private AtomicBoolean stopped;

	public List<TimerListener> getTimerListeners() {
		return timerListeners;
	}

	private int dayPeriodMs = 5000;

	public int getDayPeriodMs() {
		return dayPeriodMs;
	}

	public void setDayPeriodMs(int dayPeriodMs) {
		this.dayPeriodMs = dayPeriodMs;
	}

	public void addTimerListener(TimerListener timerListener) {
		timerListeners.add(timerListener);
	}

	public void start() {

		stopped = new AtomicBoolean(false);

		Runnable timeRunnable = new Runnable() {

			@Override
			public void run() {
				while (true) {

					while (!stopped.get()) {
						try {
							Thread.sleep(dayPeriodMs);
							for (TimerListener timerListener : timerListeners) {
								timerListener.dayPassed();
							}
						} catch (InterruptedException e) {
							System.out.println("World interrupted");
						}
					}

					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		};

		Thread timeThread = new Thread(timeRunnable);
		timeThread.start();
	}

	public void stop() {
		stopped.set(true);

	}

	public void resume() {
		stopped.set(false);
	}
}
