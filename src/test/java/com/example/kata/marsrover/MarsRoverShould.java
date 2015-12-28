package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	public Rover rover;

	@Test
	public void move_forward_twice () {
		rover = roverFacingNorthAt(0, 0);

		rover.obey("ff");

		assertThat(rover.position(), is(facingNorthAt(0, 2)));
	}

	@Test
	public void have_a_variable_starting_point () {
		rover = new Rover(facingNorthAt(0, 1));

		rover.obey("ff");

		assertThat(rover.position(), is(facingNorthAt(0, 3)));
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

		public Position position() {
			return position;
		}

		public void obey(String commands) {
			position = position.increaseY(commands.length());
		}
	}
}
