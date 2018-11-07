package Rooms;

import Game.Runner;
import People.Person;

public class Death3 extends Room
{
    public Death3(int x, int y) {
        super(x, y);

    }
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("A default came out of the dark and smacked you with a Pickaxe");
        Runner.gameOff();
    }

}

