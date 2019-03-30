package dominion;

import java.util.*;
public class GameTester {

	public static void main(String[] args) {
		Player p1 = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (Card c : p1.getDeck()) {
			System.out.println(c);
		}
		Board board = new Board(players, cardList);
		
	}
}
