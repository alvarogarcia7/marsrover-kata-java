package com.example.kata.marsrover;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

	public Rover rover;

	@Test
	public void obey_multiple_forward_commands () {
		rover =  roverFacingNorthAt(2, 0);

		rover.obey("ff");

		assertThat(rover, is(roverFacingNorthAt(2, 2)));
	}

	public static Rover roverFacingNorthAt(int x, int y) {
		return new Rover(facingNorthAt(x, y));
	}

	private static Position facingNorthAt (int x, int y) {
		return new Position(x, y, Position.Direction.N);
	}


}
