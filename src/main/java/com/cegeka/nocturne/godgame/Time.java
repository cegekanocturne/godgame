package com.cegeka.nocturne.godgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Date: 03.04.2014
 * Time: 21:25
 */
public class Time implements ITimer {

    Timer timer = new Timer();
    List<ITimeListener> listeners = new ArrayList<>();

    @Override
    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for ( ITimeListener listener : listeners) {
                    listener.dayHasPassed();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 5000);
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void registerTimeListener(ITimeListener listener) {
        listeners.add(listener);
    }
}
