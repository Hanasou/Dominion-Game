package dominion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import cards.*;

public class GameTester {

	public static void main(String[] args) {
		
		//Initialize players
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		//Add kingdom cards we're playing with here
		ArrayList<Card> cardList = new ArrayList<Card>();
		Board board = new Board(players, cardList);
		
		/*
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		DefaultListModel<Card> listModel = new DefaultListModel<Card>();
		listModel.addElement(new Copper());
		JList<Card> list = new JList<Card>(listModel);
		frame.add(list);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
	}
}

