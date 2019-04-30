package dominion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import cards.*;

public class GameTester {

	public static void main(String[] args) {
		
		Player p1 = new Player();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
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

