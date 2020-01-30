package test;

import org.junit.Before;
import org.junit.Test;

import main.*;

import static org.junit.Assert.assertEquals;

public class MoveSpec {
	private Plateau plateau;
	private Position position;
	private Move move;

	@Before
	public void beforeMoveTest() {
		plateau = new Plateau(5, 5);
		position = new Position(1, 3, 'N');
		move = new Move(plateau, position);
	}

	@Test
	public void shouldChangeDirectionToEast() throws Exception {
		char control[] = {'R'};
		position = move.movePosition(control);
		assertEquals(position.getFacing(), 'E');
	}
	
	@Test
	public void shouldChangeDirectionToSouth() throws Exception {
		char control[] = {'R','R'};
		position = move.movePosition(control);
		assertEquals(position.getFacing(), 'S');
	}
	
	@Test
	public void shouldChangeDirectionToWest() throws Exception {
		char control[] = {'L'};
		position = move.movePosition(control);
		assertEquals(position.getFacing(), 'W');
	}
	
	
	@Test
	public void shouldMoveForwardWhenDirectionIsNorth() throws Exception {
		char control[] = {'M'};
		position = move.movePosition(control);
		assertEquals(position.getX(), 1);
		assertEquals(position.getY(), 4);
	}
	
	@Test
	public void shouldMoveBackwardWhenDirectionIsSouth() throws Exception {
		char control[] = {'L','L','M'};
		position = move.movePosition(control);
		assertEquals(position.getX(), 1);
		assertEquals(position.getY(), 2);
	}
	
	@Test
	public void shouldMoveToRightWhenDirectionIsNorth() throws Exception {
		char control[] = {'R','M'};
		position = move.movePosition(control);
		assertEquals(position.getX(), 2);
		assertEquals(position.getY(), 3);
	}
	
	@Test
	public void shouldntMoveWhenXOutOfPlateau() throws Exception {
		char control[] = {'L','M','M'};
		position = move.movePosition(control);
		assertEquals(position.getX(), 0);
		assertEquals(position.getY(), 3);
	}
	
	@Test
	public void shouldntMoveWhenYOutOfPlateau() throws Exception {
		char control[] = {'M','M','M'};
		position = move.movePosition(control);
		assertEquals(position.getX(), 1);
		assertEquals(position.getY(), 5);
	}
	
}