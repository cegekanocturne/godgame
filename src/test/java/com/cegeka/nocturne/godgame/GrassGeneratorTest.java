package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GrassGeneratorTest {
    private World world;
	private GrassGenerator generator;

    @Before
    public void setup() {
        world = new World(5);
        generator = new GrassGenerator();
    }

    @Test
    public void testUnoccuppiedCells() {
        assertThat(generator.countUnocuppiedCells(world)).isEqualTo(25);
        world.setCell(new NullCreature(), 0, 0);
        assertThat(generator.countUnocuppiedCells(world)).isEqualTo(24);
    }
}
