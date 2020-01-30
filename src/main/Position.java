package main;

public class Position {
	private int x;
	private int y;
	private char facing;

	public Position(int x, int y, char facing) {
		this.x = x;
		this.y = y;
		this.facing = facing;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public char getFacing() {
		return this.facing;
	}
	
	public void setFacing(char facing) {
		this.facing = facing;
	}
	
	
}