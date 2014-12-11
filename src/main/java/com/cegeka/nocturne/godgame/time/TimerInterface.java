package com.cegeka.nocturne.godgame.time;

public interface TimerInterface {

    void addTimerListener(TimerListener timerListener);
    void start();
    void pause();
    void resume();

    void shutdown();
    boolean getStopped();
}
