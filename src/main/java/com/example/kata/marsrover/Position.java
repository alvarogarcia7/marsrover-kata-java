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
		return apply(direction.forward());
	}

	private Position apply(Location location) {
		return new Position(this.location.add(location), direction);
	}

	@Override
	public boolean equals (final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final Position position = (Position) o;

		if (direction != position.direction) return false;
		if (location != null ? !location.equals(position.location) : position.location != null) return false;

		return true;
	}

	@Override
	public int hashCode () {
		int result = location != null ? location.hashCode() : 0;
		result = 31 * result + (direction != null ? direction.hashCode() : 0);
		return result;
	}

	@Override
	public String toString () {
		return "{" +
				"[" + location.x +
				"," + location.y +
				"], " + direction +
				'}';
	}

	public static enum Direction {
		N {
			@Override
			public LocationIncrease forward () {
				return new LocationIncrease(0, 1);
			}
		},
		E {
			@Override
			public LocationIncrease forward () {
				return new LocationIncrease(1, 0);
			}
		}, W {
			@Override
			public LocationIncrease forward () {
				return new LocationIncrease(-1, 0);
			}
		}, S {
			@Override
			public LocationIncrease forward () {
				return new LocationIncrease(0, -1);
			}
		};

		public abstract LocationIncrease forward ();
	}

	private static class Location {
		private final int x;
		private final int y;

		public Location (int x, int y){
			this.x = x;
			this.y = y;
		}

		public Location add (Location other) {
			return new Location(this.x + other.x, this.y + other.y);
		}

		@Override
		public boolean equals (final Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			final Location location = (Location) o;

			if (x != location.x) return false;
			if (y != location.y) return false;

			return true;
		}

		@Override
		public int hashCode () {
			int result = x;
			result = 31 * result + y;
			return result;
		}
	}

	private static class LocationIncrease extends Location {
		public LocationIncrease(int x, int y) {
			super(x,y);
		}
	}
}
