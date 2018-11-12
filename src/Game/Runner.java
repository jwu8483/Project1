package Game;

import People.Enemy2;
import People.Person;
import People.Enemy1;
import Rooms.Room;
import Rooms.WinningRoom;
import Rooms.Death1;
import Rooms.Death2;
import Rooms.Death3;


import java.util.Scanner;

public class Runner {


	private static boolean gameOn = true;

	public static void main(String[] args) {
		Room[][] building = new Room[7][7];

		//Fill the building with normal rooms
		for (int x = 0; x < building.length; x++) {
			for (int y = 0; y < building[x].length; y++) {
				building[x][y] = new Room(x, y);
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
			x2 = (int) (Math.random() * building.length);
			y2 = (int) (Math.random() * building.length);
		}
		building[x2][y2] = new Death2(x2,y2);
		int x3 = (int)(Math.random()*building.length);
		int y3 = (int)(Math.random()*building.length);
		while (x == x3 && y ==y3 ||x1 == x3 && y1==y3 || x2 == x3 && y2 == y3)//Creates death Room1a
		{
			x3 = (int) (Math.random() * building.length);
			y3 = (int) (Math.random() * building.length);
		}
		building[x3][y3] = new Death3(x3,y3);
		int x4 = (int)(Math.random()*building.length);
		int y4 = (int)(Math.random()*building.length);
		while (x == x4 && y ==y4 ||x1 == x4 && y1==y4 || x2 == x4 && y2 == y4 || y3 == y4 && x3 == x4)//Creates death Room1a
		{
			x4 = (int) (Math.random() * building.length);
			y4 = (int) (Math.random() * building.length);
		}
		building[x4][y4] = new Death3(x4,y4);
		int r1 = (int) (Math.random() * 1 + 1);
		int r2 = (int) (Math.random() * 1 + 1);
		Person player1 = new Person(0, 0, 10);
		Enemy1 bad1 = new Enemy1(r1, r2);
		 r1 = (int) (Math.random() * 1 + 1);
		 r2 = (int) (Math.random() * 1 + 1);
		Enemy2 bad2 = new Enemy2(r1,r2);
		building[0][0].enterRoom(player1);
		building[r1][r2].EenterRoom(bad1);
		Scanner in = new Scanner(System.in);
		while (gameOn) {
			System.out.println("Where will you go? (Choose N, S, E, W)");
			String move = in.nextLine();
			int emove = (int) (Math.random() * 4 + 1);
			if (EvalidMove(emove, bad1, building)) {
				if (bad1.getx1Loc() == player1.getxLoc() && bad1.gety1Loc() == player1.getyLoc()) {
					int a = player1.gethealth();
					a = a - 1;
					player1.gethealth(a);
					System.out.println("You Feel a Presence near by -1 hp");
				} else {
					System.out.println("You should be safe");
				}
			}
			if (E1validMove(emove, bad2, building)) {
				if (bad2.getx2Loc() == player1.getxLoc() && bad2.gety2Loc() == player1.getyLoc()) {
					int a = player1.gethealth();
					a = a - 1;
					player1.gethealth(a);
					System.out.println("You Feel a Presence near by -1 hp");
				} else {
					System.out.println("You should be safe");
				}
			}

			if (validMove(move, player1, building)) {
				System.out.println("You have " + player1.gethealth() + " Health");
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

			} else {
				System.out.println("A wall blocks your path");
			}


		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 *
	 * @param move the move chosen
	 * @param p    person moving
	 * @param map  the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map) {
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}
			case "e":
				if (p.getyLoc() < map[p.getyLoc()].length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "w":
				if (p.getyLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
					return true;
				} else {
					return false;
				}
			default:
				break;

		}
		return true;
	}

	public static boolean EvalidMove(int e1move, Enemy1 a, Room[][] map) {

		switch (e1move) {
			case 1:
				if (a.getx1Loc() > 0) {
					map[a.getx1Loc()][a.gety1Loc()].EleaveRoom(a);
					map[a.getx1Loc() - 1][a.gety1Loc()].EenterRoom(a);
					return true;
				} else {
					return false;
				}
			case 2:
				if (a.gety1Loc() < map[a.gety1Loc()].length - 1) {
					map[a.getx1Loc()][a.gety1Loc()].EleaveRoom(a);
					map[a.getx1Loc()][a.gety1Loc() + 1].EenterRoom(a);
					return true;
				} else {
					return false;
				}

			case 3:
				if (a.getx1Loc() < map.length - 1) {
					map[a.getx1Loc()][a.gety1Loc()].EleaveRoom(a);
					map[a.getx1Loc() + 1][a.gety1Loc()].EenterRoom(a);
					return true;
				} else {
					return false;
				}

			case 4:
				if (a.gety1Loc() > 0) {
					map[a.getx1Loc()][a.gety1Loc()].EleaveRoom(a);
					map[a.getx1Loc()][a.gety1Loc() - 1].EenterRoom(a);
					return true;
				} else {
					return false;
				}
			default:
				break;

		}
		return true;
	}

	public static boolean E1validMove(int emove, Enemy2 b, Room[][] map) {

		switch (emove) {
			case 1:
				if (b.getx2Loc() > 0) {
					map[b.getx2Loc()][b.gety2Loc()].E1leaveRoom(b);
					map[b.getx2Loc() - 1][b.gety2Loc()].E1enterRoom(b);
					return true;
				} else {
					return false;
				}
			case 2:
				if (b.gety2Loc() < map[b.gety2Loc()].length - 1) {
					map[b.getx2Loc()][b.gety2Loc()].E1leaveRoom(b);
					map[b.getx2Loc()][b.gety2Loc() + 1].E1enterRoom(b);
					return true;
				} else {
					return false;
				}

			case 3:
				if (b.getx2Loc() < map.length - 1) {
					map[b.getx2Loc()][b.gety2Loc()].E1leaveRoom(b);
					map[b.getx2Loc() + 1][b.gety2Loc()].E1enterRoom(b);
					return true;
				} else {
					return false;
				}

			case 4:
				if (b.gety2Loc() > 0) {
					map[b.getx2Loc()][b.gety2Loc()].E1leaveRoom(b);
					map[b.getx2Loc()][b.gety2Loc() - 1].E1enterRoom(b);
					return true;
				} else {
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
