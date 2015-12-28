package com.example.kata.marsrover;

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
