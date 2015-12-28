package com.example.kata.marsrover;

public class Position{
	private final int x;
	private final int y;
	private final Location location;
	private final Direction direction;

	public Position(int x, int y, Direction facing) {
		this.x = x;
		this.y = y;
		this.location = new Location(x, y);
		this.direction = facing;
	}

	public Position (Location location, Direction facing) {
		this.x = location.x;
		this.y = location.y;
		this.location = location;
		this.direction = facing;
	}

	public Position forward() {
		if (direction == Direction.N || direction == Direction.E|| direction == Direction.W|| direction == Direction
				.S) {
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
		return new Position(this.location.add(location), direction);
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

	public static enum Direction {
		N {
			@Override
			public Location forward () {
				return new Location(0, 1);
			}
		},
		E {
			@Override
			public Location forward () {
				return new Location(1, 0);
			}
		}, W{
			@Override
			public Location forward () {
				return new Location(-1, 0);
			}
		}, S{
			@Override
			public Location forward () {
				return new Location(0, -1);
			}
		};

		public Location forward () {
			throw new RuntimeException();
		}

		;

	}

	private static class Location {
		private final int x;
		private final int y;

		public Location (int deltaX, int deltaY){
			this.x = deltaX;
			this.y = deltaY;
		}

		public Location add (Location other) {
			return new Location(this.x + other.x, this.y + other.y);
		}

	}
}
