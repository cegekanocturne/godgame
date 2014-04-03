package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by alexandp on 3/04/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class StartOfLifeTest {

    private World world;

    @Before
    public void setup() {
        world = new World(5);
        for(int i=0; i <7;i++)
            world.passTheDay();
       // world.setCell(new Grass(), 2,3);
    }

    @Test
    public void givenAWorldOfAge6_whenAfterDayPass_thenWorldContainsACellWithGrass() {
        boolean found = false;

        if(world.getAge() == 7){
            for(int x=0; x <world.getSize(); x++){
                for(int y=0; y<world.getSize(); y++){
                    if(world.getCell(x,y) != null && (world.getCell(x, y) instanceof Grass))
                       found = true;
                }
            }

            if(!found)
                fail("World age == 7, no Grass found.");
        }
    }

    @Test
    public void givenAWorldOfAge5_whenAfterDayPass_thenWorldDoesNotContainAnyACellsWithGrass() {
        if(world.getAge() < 6){
            for(int x=0; x <world.getSize(); x++){
                for(int y=0; y<world.getSize(); y++){
                   if(world.getCell(x,y) != null && (world.getCell(x, y) instanceof Grass))
                       fail("Grass found.");
                }
            }
        }
    }


}
