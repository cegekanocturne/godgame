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
    public void givenAWorld_whenRetrievingACell_thenPreviouslySavedCellIsReturned() {
        world.setCell(creature, 0, 0);
        assertThat(world.getCell(0, 0)).isEqualTo(creature);
    }

    @Test
    public void givenAWorld_whenDayPasses_thenWorldAges() {
        world.passTheDay();
        assertThat(world.getAge()).isEqualTo(1);
    }

    @Test
    public void testToString(){
        StringBuilder expected = new StringBuilder();
        for(int i=0; i<world.getSize(); i++) {
            for (int j=0; j<world.getSize(); j++)
                expected.append(world.getCell(i,j) + " ");
            expected.append(System.getProperty("line.separator"));
        }
        assertThat(world.toString()).isEqualTo(expected.toString());
    }
}
