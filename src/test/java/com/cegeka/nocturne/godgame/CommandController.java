package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandController {

    @Mock
    private Runnable timer;

    @Before
    public void setup(){
        timer = Mockito.mock(Thread.class);
    }

    @Test
    public void givenTheCounter_whenStartCommand_theTimerStarted(){

    }

    @Test
    public void givenTheCounter_whenStartCommand_thenDayCounterIsIncremented(){

    }
}
