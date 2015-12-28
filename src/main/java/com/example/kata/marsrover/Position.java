package com.example.kata.marsrover;

public class Position{
	private final int x;
	private final int y;
	private final Direction direction;

	public Position(int x, int y, Direction facing){
		this.x = x;
		this.y = y;
		this.direction = facing;
	}

	public Position increaseY(int delta) {
		return new Position(x, y + delta, direction);
	}

	public Position forward() {
		if (direction == Direction.N) {
			return new Position(x, y + 1, direction);
		}else {
			return new Position(x + 1, y, direction);
		}
	}


	@Override
	public boolean equals (final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final Position position = (Position) o;

		if (x != position.x) return false;
		if (y != position.y) return false;
		if (direction != position.direction) return false;

		return true;
	}

	public enum Direction{
		N,E;
	}
}
