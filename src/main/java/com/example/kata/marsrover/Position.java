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

	public Position forward() {
		if (direction == Direction.N) {
			return apply(direction.forward());
		}else if (direction == Direction.E) {
			return new Position(x + 1, y, direction);
		} else if (direction == Direction.W) {
			return new Position(x - 1, y, direction);
		} else if (direction == Direction.S) {
			return new Position(x, y - 1, direction);
		}
		throw new RuntimeException(String.format("Cannot find direction: '%s'", direction));
	}

	private Position apply(Location location) {
		return new Position(x + location.x, y + location.y, direction);
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

	@Override
	public String toString () {
		return "{" +
				"[" + x +
				"," + y +
				"], " + direction +
				'}';
	}

	public static enum Direction{
		N,E,W,S;
		Location forward(){
			return new Location(0,1);
		}
	}

	private static class Location {
		private final int x;
		private final int y;

		public Location (int deltaX, int deltaY){
			this.x = deltaX;
			this.y = deltaY;
		}

	}
}
