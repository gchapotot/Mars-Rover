package test;

import org.junit.Before;
import org.junit.Test;

import main.*;

import static org.junit.Assert.assertEquals;

public class PositionSpec {
	private int x;
	private int y;
	private char facing;
	private Position position;

	@Before
	public void beforePositionTest() {
		x = 3;
		y = 8;
		facing = 'N';
		position = new Position(x, y, facing);
	}

	@Test
	public void newInstancePositionCreated() throws Exception {
		assertEquals(position.getX(), 3);
		assertEquals(position.getY(), 8);
		assertEquals(position.getFacing(), 'N');
	}
}