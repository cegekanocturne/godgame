package com.cegeka.nocturne.godgame.time;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Timer implements TimerInterface {

	private List<TimerListener> timerListeners = new ArrayList<>();

    private AtomicBoolean stopped;
    private AtomicBoolean shutDown = new AtomicBoolean(false);

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
        startThread();
    }

    public void startThread() {
        Runnable timeRunnable = getTimerRunnable();
        Thread timeThread = new Thread(timeRunnable);
        timeThread.start();
    }

    private Runnable getTimerRunnable() {
        return new Runnable() {

                @Override
                public void run() {

                    while (!shutDown.get()) {

                        while (!stopped.get()) {
                            try {

                                Thread.sleep(dayPeriodMs);

                                if (!stopped.get()) {
                                    callListeners();
                                }

                            } catch (InterruptedException e) {
                                System.out.println("World interrupted");
                            }
                        }
                    }
                }
            };
    }

    public void callListeners() {
        for (TimerListener timerListener : timerListeners) {
            timerListener.dayPassed();
        }
    }

    public void pause() {
        stopped.set(true);
    }

    public void resume() {
        stopped.set(false);
    }

    @Override
    public boolean getStopped() {
        return stopped.get();
    }

    public void shutdown(){
        this.shutDown.set(true);
    }
}
