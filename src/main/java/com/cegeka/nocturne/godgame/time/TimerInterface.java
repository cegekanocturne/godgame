package com.cegeka.nocturne.godgame.time;

public interface TimerInterface {

    void addTimerListener(TimerListener timerListener);
    void start();
    void stop();
    void resume();
}
