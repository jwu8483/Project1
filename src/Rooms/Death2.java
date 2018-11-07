package Rooms;

import Game.Runner;
import People.Person;

public class Death2 extends Room
{
    public Death2(int x, int y) {
        super(x, y);

    }
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You open the door and feel a sharp knife to your throat. A sharp pain hits, and you black out");
        Runner.gameOff();
    }


}


