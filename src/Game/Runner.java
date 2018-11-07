package Game;

import People.Person;
import Rooms.Room;
import Rooms.WinningRoom;
import Rooms.Death1;
import Rooms.Death2;
import Rooms.Death3;
import Rooms.Death4;
import Rooms.ShieldRoom;
import Rooms.PendantRoom;


import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		
		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		int x1 = (int)(Math.random()*building.length);
		int y1 = (int)(Math.random()*building.length);
		while (x1 == x && y ==y1)//Creates death Room1a
		{
			 x1 = (int)(Math.random()*building.length);
			 y1 = (int)(Math.random()*building.length);
		}
		building[x1][y1] = new Death1(x1,y1);
		int x2 = (int)(Math.random()*building.length);
		int y2 = (int)(Math.random()*building.length);
		while (x == x2 && y ==y2 ||x1 == x2 && y1==y2)//Creates death Room1a
		{
			x2 = (int)(Math.random()*building.length);
			y2 = (int)(Math.random()*building.length);
		}
		building[x2][y2] = new Death2(x2,y2);
		 
		 //Setup player 1 and the input scanner
		Person player1 = new Person( 0,0, 10 );
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where will you go? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("A wall blocks your path");
			}
			
			
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	


}
