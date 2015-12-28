package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	@Test
	public void move_forward_twice () {
		Rover rover = new Rover(position(0,0));

		rover.obey("ff");

		assertThat(rover.position(), is(position(0, 2, Direction.N)));
	}

	@Test
	public void have_a_variable_starting_point () {
		Rover rover = new Rover(position(0,1,Direction.N));

		rover.obey("ff");

		assertThat(rover.position(), is(position(0, 3, Direction.N)));
	}

	private static Position position(int x, int y, Direction... facing) {
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
