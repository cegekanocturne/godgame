package com.cegeka.nocturne.godgame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GrassGeneratorTest {
	private World world;
	private GrassGenerator generator;
    @Mock
    private Creature dummyCreature;

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

	@Test
	public void testGenerateRandomUnoccuppiedPosition() {
		for (int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				world.setCell(new NullCreature(), i, j);
			}
		}
		assertThat(generator.generateUnoccupiedPosition(world)).isNull();

		world.setCell(null, 2, 3);
		assertThat(generator.generateUnoccupiedPosition(world)).isEqualTo(
				new IntPair(2, 3));

	}

	@Test
	public void having7Days_generateOneGrass() {
		for (int i = 0; i < world.getSize(); i++) {
			for (int j = 0; j < world.getSize(); j++) {
				world.setCell(dummyCreature, i, j);
			}
		}
		world.setCell(null, 2, 3);
		for (int i = 0; i < 6; i++) {
			world.dayPassed();
		}
		assertThat(world.getCell(2, 3)).isNull();
		
		world.dayPassed();
		assertThat(world.getCell(2, 3)).isInstanceOf(GrassCreature.class);
				
	}
	
	@Test
	public void having7Days_generateExactlyOneGrass() {
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(25);
		
		for (int i = 0; i < 6; i++) {
			world.dayPassed();
		}
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(25);
		world.dayPassed();
		
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(24);						
	}
	
	@Test
	public void having14Days_generateExactlyOneGrass() {
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(25);
		
		for (int i = 0; i < 13; i++) {
			world.dayPassed();
		}
		
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(24);
		
		world.dayPassed();		
		assertThat(GrassGenerator.countUnocuppiedCells(world)).isEqualTo(23);						
	}
	
}
