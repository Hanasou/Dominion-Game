package dominion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import cards.*;

public class Board extends JFrame{

	private ArrayList<Player> players;
	private ArrayList<Stack<Card>> tv;
	private ArrayList<Stack<Card>> kingdom;
	private ArrayList<Card> trash;
	private CardDictionary dict;
	
	public Board(ArrayList<Player> players, ArrayList<Card> cardList) {
		this.trash = new ArrayList<Card>();
		this.kingdom = new ArrayList<Stack<Card>>();
		this.dict = new CardDictionary();
		this.tv = new ArrayList<Stack<Card>>();
		
		//Initialize stacks of cards
		for (int i = 0; i < 7; i++) {
			tv.add(new Stack<Card>());
		}
		//Add all the treasure and victory cards into the stacks.
		for (int i = 0; i < 50; i++) {
			tv.get(0).push(new Copper());
		}
		for (int i = 0; i < 50; i++) {
			tv.get(1).push(new Silver());
		}
		for (int i = 0; i < 50; i++) {
			tv.get(2).push(new Gold());
		}
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
		
		
		int i = 0;
		while (true) {
			Player currPlayer = players.get(i);
			currPlayer.setTurnActive();
			add(currPlayer.getArea(), BorderLayout.CENTER);
			pack();
			while (currPlayer.activeTurn()) {
				
			}
			remove(currPlayer.getArea());
			i++;
			if (i == players.size()) {
				i = 0;
			}
		}
	}
}
