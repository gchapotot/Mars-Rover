package main;

public class Plateau {
	private int limitX;
	private int limitY;

	public Plateau(int limitX, int limitY) {
		this.setLimitX(limitX);
		this.setLimitY(limitY);
	}

	public int getLimitX() {
		return this.limitX;
	}

	public void setLimitX(int limitX) {
		this.limitX = limitX;
	}

	public int getLimitY() {
		return this.limitY;
	}

	public void setLimitY(int limitY) {
		this.limitY = limitY;
	}


}