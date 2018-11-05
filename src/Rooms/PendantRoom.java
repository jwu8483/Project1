package Rooms;

import Game.Runner;
import People.Person;

public class PendantRoom extends Room
{
    public PendantRoom(int x, int y) {
        super(x, y);

    }
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You enter the room and the door shuts behind you. You feel a hand cover your mouth and you then black out.");
        Runner.gameOff();
    }


}