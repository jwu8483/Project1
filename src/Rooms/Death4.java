package Rooms;

import Game.Runner;
import People.Person;

public class Death4 extends Room
{
    public Death4(int x, int y) {
        super(x, y);

    }
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You find out you got a 65 in an ap Java project and have a heartattack");
        Runner.gameOff();
    }

}

