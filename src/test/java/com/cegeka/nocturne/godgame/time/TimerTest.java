package com.cegeka.nocturne.godgame.time;

import com.cegeka.nocturne.godgame.Creature;
import com.cegeka.nocturne.godgame.World;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class TimerTest {

    @Spy
    private Timer timer = new Timer();

    @Mock
    private Creature creature;
    private World world;

    @Before
    public void setup() throws InterruptedException {

        world = new World(5);
        timer.addTimerListener(world);

        doNothing().when(timer).startThread();
    }

    @After
    public void tearDown() {
        timer.shutdown();
    }

    @Test
    public void givenATimerIsStarted() throws InterruptedException {
        timer.start();
        timer.callListeners();
        assertThat(world.getAge()).isEqualTo(1);
    }

    @Test
    public void testPause() throws InterruptedException {
        timer.start();
        timer.callListeners();
        assertThat(world.getAge()).isEqualTo(1);

        timer.pause();
        assertThat(world.getAge()).isEqualTo(1);
    }

    @Test
    public void testResume() throws InterruptedException {

        testPause();

        timer.resume();
        timer.callListeners();

        assertThat(world.getAge()).isEqualTo(2);
    }
}
