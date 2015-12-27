package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	@Test
	public void move_forward_twice () {
		Rover rover = new Rover();

		rover.obey("ff");

		assertThat(rover.position(), is(position(0, 2, Direction.N)));
	}

	private static Position position(int x, int y, Direction facing){
		return new Position(x,y,facing);
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

		private int y;

		public Position position() {
			return new Position(0, y, Direction.N);
		}

		public void obey(String commands) {
			this.y = commands.length();
		}
	}
}