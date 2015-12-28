package com.example.kata.marsrover;

import org.junit.Test;

import static com.example.kata.marsrover.Delta_II.facingEastAt;
import static com.example.kata.marsrover.Delta_II.facingNorthAt;
import static com.example.kata.marsrover.Delta_II.facingSouthAt;
import static com.example.kata.marsrover.Delta_II.facingWestAt;
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
	public void start_facing_from_the_east () {

		rover = facingEastAt(1, 2);

		rover.obey("f");

		assertThat(rover, is(facingEastAt(2, 2)));
	}

	@Test
	public void start_facing_from_the_west () {

		rover = facingWestAt(3, 2);

		rover.obey("f");

		assertThat(rover, is(facingWestAt(2, 2)));
	}

	@Test
	public void start_facing_from_the_south() {

		rover = facingSouthAt(2, 3);

		rover.obey("f");

		assertThat(rover, is(facingSouthAt(2, 2)));
	}

	@Test
	public void move_twice_from_another_direction () {

		rover = facingEastAt(1, 2);

		rover.obey("ff");

		assertThat(rover, is(facingEastAt(3, 2)));
	}
}
