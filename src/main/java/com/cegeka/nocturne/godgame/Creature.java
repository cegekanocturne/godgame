package com.cegeka.nocturne.godgame;

public interface Creature {


    int getAge();
    void setAge(int age);

    void age();

    boolean shouldDie();

    String render();
}
