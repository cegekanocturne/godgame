package com.cegeka.nocturne.godgame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisplayerTest {
	
	protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final String EOL = System.getProperty("line.separator");

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}
	
    @Test
    public void itOutputsToOutputStreamWithNoCreatures() {
        World w = new World(2);
        Displayer d =new Displayer(w);
        
        d.display();
        
        String expected=
        		"++++" + EOL + 
        		"+  +" + EOL +
        		"+  +" + EOL + 
        		"++++" + EOL +
        		"Time: 0" + EOL;
		Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }
    
    @Test
    public void itOutputsToOutputStreamWithCreatures() {
    	World w = new World(2);
    	w.setCell(new GrassCreature(), 1, 1);
    	Displayer d = new Displayer(w);
    	
    	d.display();
    	
    	String expected=
    			"++++" + EOL + 
    			"+  +" + EOL +
    			"+ G+" + EOL + 
    			"++++" + EOL +
    			"Time: 0" + EOL;
    	Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }
    
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}
}