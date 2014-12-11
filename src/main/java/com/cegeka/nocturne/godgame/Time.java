package com.cegeka.nocturne.godgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Date: 03.04.2014
 * Time: 21:25
 */
public class Time {

    Timer timer = new Timer();
    List<ITimeListener> listeners = new ArrayList<>();

    public void start() {
        System.out.println("World start NOW!!");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for ( ITimeListener listener : listeners) {
                    listener.passTheDay();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 500, 5000);
    }

    public void pause() {
        System.out.println("World is tired, taking a pause....");
        timer.cancel();
    }

    public void registerTimeListener(ITimeListener listener) {
        listeners.add(listener);
    }

    public void resume(){
        start();
    }
}
