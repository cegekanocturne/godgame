package com.cegeka.nocturne.godgame;

public class Displayer {
	private World world;

	public Displayer(World world) {
		super();
		this.world = world;
	}

	public void display() {
		printEntireBorder();
		
		for (int y = 0; y < world.getSize(); y++) {
			System.out.print("+");
			for (int x = 0; x < world.getSize(); x++) {
				
				Creature c = world.getCell(x, y);
				if (c == null) {
					System.out.print(" ");
				} else {
					System.out.print(c.getSymbol());
				}

			}
			
			System.out.print("+");
			System.out.println();
		}


		printEntireBorder();
		
		System.out.println("Time: "+world.getAge());
	}

	private void printEntireBorder() {
		for (int x = 0; x < world.getSize()+2; x++) {
			System.out.print("+");
		}
		System.out.println();
	}

}
