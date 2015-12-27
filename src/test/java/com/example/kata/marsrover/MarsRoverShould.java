package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	@Test
	public void move_forward () {
		Rover rover = new Rover();

		rover.obey("f");

		assertThat(rover.position(), is(position(0, 1, Direction.N)));
	}

	private static Position position(int x, int y, Direction facing){
		return new Position(x,y,facing);
	}

	private static class Position{
		public Position(int x, int y, Direction facing){
		}
	}

	private enum Direction{
		N;
	}

	private static class Rover{
		public Position position() {
			return new Position(0, 1, Direction.N);
		}

		public void obey(String commands){

		}
	}
}
