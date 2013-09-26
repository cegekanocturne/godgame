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
    public void givenAGrass_it_should_die_in_the_14th_day() {
        world.setCell(new Grass(), 0, 0);
        ageTheWorld(13);

        world.passTheDay();

        assertThat(world.getCell(0, 0)).isNull();
    }

    private void ageTheWorld(int days) {
        for (int i = 0; i < days; i++) {
            world.passTheDay();
        }
    }

    @Test
    public void givenAWorld_a_dear_appears_in_the_19th_day() {
        ageTheWorld(19);
        world.passTheDay();

        assertThat(findTheDeer()).isNotNull();
    }

    @Test
    public void a_Deer_The_Deer_Ages() {
        ageTheWorld(20);
        world.passTheDay();
        assertThat(findTheDeer().getAge()).isEqualTo(1);

    }

    @Test
    public void givenADeer_it_should_die_in_the_30th_day() {
        ageTheWorld(20);
        assertThat(findTheDeer()).isNotNull();

        ageTheWorld(29);

        world.passTheDay();

        assertThat(findTheDeer()).isNull();
    }

    private Deer findTheDeer() {
        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                if (world.getCell(i, j) instanceof Deer)
                    return (Deer) world.getCell(i, j);
            }
        }
        return null;
    }
}