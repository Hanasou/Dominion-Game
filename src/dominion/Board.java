package dominion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import cards.*;

public class Board extends JFrame{

	private ArrayList<Player> players;
	//private Player currPlayer;
	private ArrayList<Stack<Card>> tv;
	private ArrayList<Stack<Card>> kingdom;
	private ArrayList<Card> trash;
	private CardDictionary dict;
	private PlayArea playArea;
	
	
	public Board(ArrayList<Player> players, ArrayList<Card> cardList) {
		this.trash = new ArrayList<Card>();
		this.kingdom = new ArrayList<Stack<Card>>();
		this.dict = new CardDictionary();
		this.tv = new ArrayList<Stack<Card>>();
		this.playArea = new PlayArea(players);
		//this.currPlayer = players.get(0);
		
		//currPlayer.setActiveTurn(true);
		//Initialize stacks of cards
		for (int i = 0; i < 7; i++) {
			tv.add(new Stack<Card>());
		}
		
		//Label the stacks as variables
		Stack<Card> copperStack = tv.get(0);
		Stack<Card> silverStack = tv.get(1);
		Stack<Card> goldStack = tv.get(2);
		Stack<Card> estateStack = tv.get(3);
		Stack<Card> duchyStack = tv.get(4);
		Stack<Card> provinceStack = tv.get(5);
		Stack<Card> curseStack = tv.get(6);
		
		//Add all the treasure and victory cards into the stacks.
		for (int i = 0; i < 50; i++) {
			copperStack.push(new Copper());
		}
		for (int i = 0; i < 50; i++) {
			silverStack.push(new Silver());
		}
		for (int i = 0; i < 50; i++) {
			goldStack.push(new Gold());
		}
		for (int i = 0; i < 8; i++) {
			estateStack.push(new Estate());
		}
		for (int i = 0; i < 8; i++) {
			duchyStack.push(new Duchy());
		}
		for (int i = 0; i < 8; i++) {
			provinceStack.push(new Province());
		}
		
		//Set the frame to border layout
		setLayout(new BorderLayout());
		JPanel cardPanel = new JPanel(new BorderLayout());
		JPanel tvPanel = new JPanel(new FlowLayout());
		
		//Add the treasures here
		tvPanel.add(new JLabel(new CardIcon("Copper", "card_img/copper.png")));
		tvPanel.add(new JLabel(new CardIcon("Silver", "card_img/silver.png")));
		tvPanel.add(new JLabel(new CardIcon("Gold", "card_img/gold.png")));
		tvPanel.add(new JLabel(new CardIcon("Estate", "card_img/estate.png")));
		tvPanel.add(new JLabel(new CardIcon("Duchy", "card_img/duchy.png")));
		tvPanel.add(new JLabel(new CardIcon("Province", "card_img/province.png")));
		JPanel kingdomPanel = new JPanel(new GridLayout(2,5, 10, 10));
		
		//Add action cards
		
		//Add victory cards
		cardPanel.add(tvPanel,BorderLayout.NORTH);
		cardPanel.add(kingdomPanel, BorderLayout.CENTER);
		add(cardPanel, BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(playArea, BorderLayout.CENTER);
		pack();
		//Rotate player's turns here. Add player's boards.
		/*
		int i = 0;
		currPlayer = players.get(i);
		add(playArea, BorderLayout.CENTER);
		pack();
		*/
		/*
		while (true) {
			while (currPlayer.activeTurn()) {
				Thread.yield();
				if (currPlayer.getArea().getTurn() == false) {
					currPlayer.setActiveTurn(false);
					break;
				}
			}
			//remove(currPlayer.getArea());
			remove(currPlayer.getArea());
			i++;
			if (i == players.size()) {
				i = 0;
			}
			currPlayer = players.get(i);
			add(currPlayer.getArea(), BorderLayout.CENTER);
			currPlayer.setActiveTurn(true);
			currPlayer.resetTurn();
			pack();
		}
		*/
	}
}

