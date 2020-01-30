package main;

public class Print {
	private Position pos;
	
	public Print(Position pos) {
		this.pos = pos;
	}
	
	public void printPosition() {
		System.out.println(this.pos.getX() + " " + this.pos.getY() + " " + this.pos.getFacing());
	}
}