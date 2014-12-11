package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WorldTest {

    @Mock
    private Creature creature;
    private World world;

    @Before
    public void setup() {
        world = new World(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenASizeSmallerOrEqualToZero_whenCreatingAWorld_thenThrowIllegalArgumentException() {
        new World(0);
    }

    @Test
    public void givenASize_whenCreatingAWorld_thenWorldHasCorrectCellCount() {
        assertThat(world.getCellCount()).isEqualTo(25);
    }

    @Test
    public void givenAWorld_whenRetrievingAnEmptyCell_thenNullOmg() {
        assertThat(world.getCell(3, 3)).isEqualTo(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void givenAWorld_itIsSadlyFinite() {
        world.getCell(6, 6);
    }

    @Test
    public void givenAWorld_whenRetrievingACell_thenPreviouslySavedCellIsReturned() {
        world.setCell(creature, 0, 0);

        assertThat(world.getCell(0, 0)).isEqualTo(creature);
    }

    @Test
    public void givenABraveNewWorld_whenDayPasses_thenWorldAges() {
        assertThat(world.getAge()).isEqualTo(0);
        world.passTheDay();
        assertThat(world.getAge()).isEqualTo(1);
    }
}
