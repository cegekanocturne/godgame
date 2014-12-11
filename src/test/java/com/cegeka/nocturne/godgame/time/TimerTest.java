package com.cegeka.nocturne.godgame.time;

import com.cegeka.nocturne.godgame.Creature;
import com.cegeka.nocturne.godgame.World;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TimerTest {

    private TimerInterface timer = new Timer();

    @Mock
    private Creature creature;
    private World world;

    @Before
    public void setup() {
        world = new World(5);
        timer.addTimerListener(world);
    }

    @Test
    public void givenATimerIsStarted() throws InterruptedException {
        timer.start();
        Thread.sleep(5050);
        assertThat(world.getAge()).isEqualTo(1);
    }
}
