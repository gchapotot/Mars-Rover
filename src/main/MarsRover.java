package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarsRover {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		int inputLine = 1;
		//Plateau coordinates
		int xLimit = 0;
		int yLimit = 0;
		//Rover coordinates
		int x = 0;
		int y = 0;
		char facing = 'N';
		//Rover instructions
		char control[];
		
		Plateau plateau = null;
		Position pos = null;
		
		//Read input file
		br = new BufferedReader(new FileReader(args[0]));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				if (inputLine == 1) {
					if (line.length() == 3) {
						xLimit = Character.getNumericValue(line.charAt(0));
						yLimit = Character.getNumericValue(line.charAt(2));
						//Create the plateau
						plateau = new Plateau(xLimit, yLimit);
						inputLine++;
					} else {
						throw new RuntimeException("Incorrect Plateau coordinates - Expected format: 'x y' with x,y > 0");
					}
				} else if (inputLine % 2 == 0) {
					if (line.length() == 5 && (line.charAt(4) == 'N' || line.charAt(4) == 'S' || line.charAt(4) == 'W'
							|| line.charAt(4) == 'E')) {
						x = Character.getNumericValue(line.charAt(0));
						y = Character.getNumericValue(line.charAt(2));
						facing = line.charAt(4);
						if (x<0 || x>xLimit || y<0 || y>yLimit) {
							throw new RuntimeException("Rover coordinates out of Plateau !");
						}
						else {
							//Set Rover initial position
							pos = new Position(x, y, facing);
							inputLine++;
						}
					} else {
						throw new RuntimeException("Incorrect Rover coordinates - Expected format: 'x y Z' with Z in [N,S,E,W]");
					}
				} else if (inputLine % 2 == 1) {
					if (line instanceof String) {
						control = line.toCharArray();
						//Explore the plateau
						Move move = new Move(plateau, pos);
						pos = move.movePosition(control);
						//Print output
						Print print = new Print(pos);
						print.printPosition();
						inputLine++;
					} else {
						throw new RuntimeException("Incorrect instructions format !");
					}
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}