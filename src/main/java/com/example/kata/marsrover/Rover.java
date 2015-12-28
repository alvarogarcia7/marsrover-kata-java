package com.example.kata.marsrover;

public class Rover{

	private Position position;

	public Rover (final Position position) {
		this.position = position;
	}

	public void obey(String commands) {
		for (int i = 0; i < commands.length(); i++) {
			position = position.forward();
		}
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
