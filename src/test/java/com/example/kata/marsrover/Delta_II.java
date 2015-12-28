package com.example.kata.marsrover;

/**
 * Rover Factory
 *
 * See https://en.wikipedia.org/wiki/Mars_Exploration_Rover#History,
 * https://en.wikipedia.org/wiki/Delta_II
 */
public class Delta_II {

	public static Rover facingNorthAt (int x, int y) {
		return landRoverAt(x, y, Position.Direction.N);
	}

	public static Rover facingEastAt(int x, int y) {
		return landRoverAt(x, y, Position.Direction.E);
	}

	public static Rover facingWestAt (int x, int y) {
		return landRoverAt(x, y, Position.Direction.W);
	}

	public static Rover facingSouthAt (int x, int y) {
		return landRoverAt(x, y, Position.Direction.S);
	}

	private static Rover landRoverAt(int x, int y, Position.Direction facing){
		return new Rover(new Position(x, y, facing));
	}
}
