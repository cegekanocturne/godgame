package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Timer;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandControllerTest {

    @Mock
    private Time timer;
    @Mock
    private World world;

    @Before
    public void setup(){
        timer = Mockito.mock(Time.class);
        world = Mockito.mock(World.class);
    }

    @Test
    public void givenTheCounter_whenStartCommand_thenDayCounterIsIncremented(){
        timer.start();
        try {
            Thread.sleep(10000);
            Mockito.verify(world,Mockito.times(2)).passTheDay();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheCounter_whenPauseCommand_thenDayCounterShouldFreeze(){
        timer.start();
        timer.pause();
        int counter = world.getAge();
        try {
            Thread.sleep(5000);
            assertThat(world.getAge()).isEqualTo(counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheCounter_whenResumeCommand_thenDayCounterShouldBeIncremented(){
        timer.start();
        timer.pause();
        int counter = world.getAge();
        timer.resume();
        try {
            Thread.sleep(5000);
            assertThat(world.getAge()).isEqualTo(counter+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
