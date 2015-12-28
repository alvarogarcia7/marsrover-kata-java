package com.example.kata.marsrover;

import org.junit.Test;

import static com.example.kata.marsrover.Position.*;
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

	@Test
	public void start_facing_another_direction () {

		rover = facingEastAt(1, 2);

		rover.obey("f");

		assertThat(rover, is(facingEastAt(2, 2)));
	}

	@Test
	public void move_twice_from_another_direction () {

		rover = facingEastAt(1, 2);

		rover.obey("ff");

		assertThat(rover, is(facingEastAt(3, 2)));
	}

	public static Rover facingNorthAt (int x, int y) {
		return landRoverAt(x, y, Direction.N);
	}

	public static Rover facingEastAt(int x, int y) {
		return landRoverAt(x, y, Direction.E);
	}

	private static Rover landRoverAt(int x, int y, Direction facing){
		return new Rover(new Position(x, y, facing));
	}
}
