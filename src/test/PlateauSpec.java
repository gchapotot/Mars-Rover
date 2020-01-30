package test;

import org.junit.Before;
import org.junit.Test;

import main.*;

import static org.junit.Assert.assertEquals;

public class PlateauSpec {
	private int x;
	private int y;
	private Plateau plateau;

	@Before
	public void beforePlateauTest() {
		x = 5;
		y = 5;
		plateau = new Plateau(x,y);
	}
	
	@Test
    public void newInstancePlateauCreated() throws Exception{
        assertEquals(plateau.getLimitX(), 5);
        assertEquals(plateau.getLimitY(), 5);
    }
}