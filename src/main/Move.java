package main;

public class Move{
	private Position position;
	private Plateau plateau;

	public Move(Plateau plateau, Position position) {
		this.plateau = plateau;
		this.position = position;
	}
	
	public Position movePosition(char control[]) {
		char facing = this.position.getFacing();
		for (int i = 0; i < control.length; i++) {

			if (facing == 'N' && control[i] == 'L') {
				facing = 'W';
			}

			else if (facing == 'W' && control[i] == 'L') {
				facing = 'S';
			}

			else if (facing == 'S' && control[i] == 'L') {
				facing = 'E';
			}

			else if (facing == 'E' && control[i] == 'L') {
				facing = 'N';
			}

			else if (facing == 'N' && control[i] == 'R') {
				facing = 'E';
			}

			else if (facing == 'E' && control[i] == 'R') {
				facing = 'S';
			}

			else if (facing == 'S' && control[i] == 'R') {
				facing = 'W';
			}

			else if (facing == 'W' && control[i] == 'R') {
				facing = 'N';
			}
			this.position.setFacing(facing);
			if (control[i] == 'M') {
				int x = this.position.getX();
				int y = this.position.getY();
				this.position = moveRover(x, y, this.position.getFacing());
			}
		}
		return this.position;
	}

	private Position moveRover(int x, int y, char facing) {
		
		if (facing == 'N' && y < this.plateau.getLimitY()) {
			y++;
		} else if (facing == 'E' && x < this.plateau.getLimitX()) {
			x++;
		} else if (facing == 'S' && y > 0) {
			y--;
		} else if (facing == 'W' && x > 0) {
			x--;
		}
		return new Position(x, y, facing);
	}

}
