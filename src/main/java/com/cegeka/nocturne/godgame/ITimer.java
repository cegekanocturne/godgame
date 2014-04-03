package com.cegeka.nocturne.godgame;

/**
 * Date: 03.04.2014
 * Time: 21:01
 */
public interface ITimer {
    void start();
    void pause();

    void registerTimeListener(ITimeListener listener);
}
