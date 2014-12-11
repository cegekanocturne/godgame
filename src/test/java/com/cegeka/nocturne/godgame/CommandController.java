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
public class CommandController {

    @Mock
    private Timer timer;
    @Mock
    private World world;

    @Before
    public void setup(){
        timer = Mockito.mock(Timer.class);
        world = Mockito.mock(World.class);
        //world.setTimer(timer);
    }

    @Test
    public void givenTheCounter_whenStartCommand_theTimerStarted(){

    }

    @Test
    public void givenTheCounter_whenStartCommand_thenDayCounterIsIncremented(){

    }

    @Test
    public void givenTheCounter_whenPauseCommand_thenDayCounterShouldFreeze(){

    }

    @Test
    public void givenTheCounter_whenResumeCommand_thenDayCounterShouldBeIncremented(){

    }
}
