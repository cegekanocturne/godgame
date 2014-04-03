package com.cegeka.nocturne.godgame;

/**
 * Date: 03.04.2014
 * Time: 20:51
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Timer;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TimeTest {

    @Mock
    private World world;

    @Before
    public void setup() {
        world = new World(5);
    }

    @Test
    public void dummy() {

    }
    //@Test
    public void givenAWorld_whenFiveRealSecPasses_thenOneGameDayPasses() throws InterruptedException {
        int age = world.getAge();
        Thread.sleep(5000);
        //world.
        //Timer t;
        //t.scheduleAtFixedRate();
        assertThat(world.getAge()).isEqualTo(age+1);
    }
}
