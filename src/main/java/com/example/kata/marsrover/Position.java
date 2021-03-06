package com.example.kata.marsrover;

public class Position{
	private final Location location;
	private final Direction direction;

	public Position(int x, int y, Direction facing) {
		this(new Location(x, y), facing);
	}

	private Position (Location location, Direction facing) {
		this.location = location;
		this.direction = facing;
	}

	public Position forward() {
		return apply(direction.forward());
	}

	public Position backward() {
		return apply(direction.backward());
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
				return LocationIncrease.axisY;
			}
		},
		E {
			@Override
			public LocationIncrease forward () {
				return LocationIncrease.axisX;
			}
		},
		W,
		S;

		protected Direction opposite;

		static {
			makeOpposites(N,S);
			makeOpposites(E,W);

			checkOppositeConfiguration();
		}

		private static void makeOpposites(Direction a, Direction b){
			a.opposite = b;
			b.opposite = a;
		}

		private static void checkOppositeConfiguration(){
			for (Direction current : values()) {
				// the opposite of my opposite is me
				assert current.opposite.opposite == current;
			}
		}

		public LocationIncrease forward () {
			return this.opposite.forward().negated();
		}

		public LocationIncrease backward () {
			return this.opposite.forward();
		}
	}

	private static class Location {
		protected final int x;
		protected final int y;

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

		public static final LocationIncrease axisY = new LocationIncrease(0, 1);
		public static final LocationIncrease axisX = new LocationIncrease(1, 0);

		public LocationIncrease(int x, int y) {
			super(x,y);
		}

		public LocationIncrease negated(){
			return new LocationIncrease(-this.x, -this.y);
		}
	}
}
