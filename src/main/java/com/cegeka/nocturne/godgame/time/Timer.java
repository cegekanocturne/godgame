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

    public void addTimerListener(TimerListener timerListener) {
        timerListeners.add(timerListener);
    }

    public void start() {

        stopped = new AtomicBoolean(false);

        Runnable timeRunnable = new Runnable() {

            @Override
            public void run() {

                while (!stopped.get()) {
                    try {
                        Thread.sleep(5000);
                        for (TimerListener timerListener : timerListeners) {
                            timerListener.dayPassed();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("World interrupted");
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
