package Rooms;

import People.Enemy1;
import People.Enemy2;
import People.Person;

public class Room {
	Person occupant;
	Enemy1 occupant1;
	Enemy2 occupant2;
	int xLoc, yLoc;

	public Room(int x, int y) {
		xLoc = x;
		yLoc = y;
	}

	/**
	 * Method controls the results when a person enters this room.
	 *
	 * @param x the Person entering
	 */
	public void enterRoom(Person x) {
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 *
	 * @param x
	 */
	public void leaveRoom(Person x) {
		occupant = null;
	}

	public void EenterRoom(Enemy1 a)
	{
		occupant1 = a;
		a.setx1Loc(this.xLoc);
		a.sety1Loc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void EleaveRoom(Enemy1 x)
	{
		occupant = null;
	}
	public void E1enterRoom(Enemy2 b)
	{
		occupant2 = b;
		b.setx2Loc(this.xLoc);
		b.sety2Loc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void E1leaveRoom(Enemy2 x)
	{
		occupant = null;
	}
}
