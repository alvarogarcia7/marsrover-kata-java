package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	public Rover rover;

	@Test
	public void obey_multiple_forward_commands () {
		rover = roverFacingNorthAt(2, 0);

		rover.obey("ff");

		assertThat(rover, is(roverFacingNorthAt(2, 2)));
	}

	public static Rover roverFacingNorthAt(int x, int y) {
		return new Rover(facingNorthAt(x, y));
	}

	private static Position facingNorthAt (int x, int y) {
		return new Position(x, y, Direction.N);
	}

	private static class Position{
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
	}

	private enum Direction{
		N;
	}

	private static class Rover{

		private Position position;

		public Rover (final Position position) {
			this.position = position;
		}

		public void obey(String commands) {
			position = position.increaseY(commands.length());
		}

		@Override
		public boolean equals (final Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			final Rover rover = (Rover) o;

			if (position != null ? !position.equals(rover.position) : rover.position != null) return false;

			return true;
		}

		@Override
		public int hashCode () {
			return position != null ? position.hashCode() : 0;
		}
	}
}
