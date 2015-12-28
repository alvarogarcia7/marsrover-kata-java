package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	public Rover rover;

	@Test
	public void obey_multiple_forward_commands () {
		rover =  facingNorthAt(2, 0);

		rover.obey("ff");

		assertThat(rover, is(facingNorthAt(2, 2)));
	}

	public static Rover facingNorthAt (int x, int y) {
		return new Rover(new Position(x, y, Position.Direction.N));
	}
}
