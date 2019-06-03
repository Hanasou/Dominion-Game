package dominion;

import java.util.*;

public class Player {
	/**
	 * Attributes the player has. 
	 * TODO: Hand, Deck, Discard pile, other stuff I might be missing
	 */
	private String name;
	private int actions;
	private int money;
	private int victory;
	private int buys;
	private Hand hand;
	private Deck deck;
	private Discards discards;
	private boolean actionPhase;
	private boolean activeTurn;
	private ArrayList<Card> inPlay;
	
	public Player(String name) {
		this.name = name;
		this.actions = 1;
		this.money = 0;
		this.victory = 0;
		this.buys = 1;
		this.actionPhase = true;
		this.activeTurn = false;
		this.hand = new Hand();
		this.deck = new Deck();
		this.discards = new Discards();
		this.inPlay = new ArrayList<Card>();
		
		drawHand();
	}
	
	public boolean getActionPhase() {
		return actionPhase;
	}
	public String getName() {
		return name;
	}
	
	public boolean activeTurn() {
		return activeTurn;
	}
	
	public int getActions() {
		return actions;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getBuys() {
		return buys;
	}
	
	public int getVictory() {
		return victory;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public Discards getDiscards() {
		return discards;
	}
	
	public ArrayList<Card> getInPlay() {
		return inPlay;
	}
	
	public void setActions(int a) {
		this.actions = a;
	}
	
	public void setMoney(int a) {
		this.money = a;
	}
	
	public void setVictory(int v) {
		this.victory = v;
	}
	
	public void setActiveTurn(boolean b) {
		this.activeTurn = b;
	}
	
	/**
	 * Whenever the turn gets swapped, call this method.
	 */
	public void resetTurn() {
		this.actions = 1;
		this.buys = 1;
		this.money = 0;
		
		discards.addAll(hand);
		discards.addAll(inPlay);
		hand.empty();
		inPlay.removeAll(inPlay);
		drawHand();
		activeTurn = true;
		actionPhase = true;
	}
	
	/**
	 * When you're done playing actions.
	 */
	public void endActions() {
		actionPhase = false;
	}
	
	/**
	 * When you draw the last card of your deck.
	 */
	public void reshuffle() {
		deck.addAll(discards);
		discards.empty();
		deck.shuffle();
	}
	
	public void draw() {
		Card drawThis = deck.pop();
		hand.add(drawThis);
		if (deck.isEmpty()) {
			reshuffle();
		}
	}
	
	public void drawHand() {
		for (int i = 0; i < 5; i++) {
			draw();
		}
	}
	
	public void play(Card c) {
		if (c instanceof Action) {
			if (actions == 0) {
				System.out.println("No actions left");
			}
			else if (actionPhase == false) {
				System.out.println("Not Action Phase");
			}
			else {
				actions--;
				c.activate(this);
				hand.remove(c);
				inPlay.add(c);
			}
		}
		else if (c instanceof Treasure) {
			if (actionPhase == true) {
				System.out.println("Can't play treasure on action phase");
			}
			else {
				hand.remove(c);
				c.activate(this);
				inPlay.add(c);
			}
		}
		else {
			System.out.println("Select Something Valid");
		}
	}
	
	public void playTreasures() {
		ArrayList<Card> playThese = new ArrayList<Card>();
		for (Card c : getHand()) {
			if (c instanceof Treasure) {
				playThese.add(c);
			}
		}
		
		for (Card c : playThese) {
			play(c);
		}
	}
	
	/**
	 * Buy a card
	 */
	public void buy(Card c) {
		if (money >= c.getCost()) {
			money = money - c.getCost();
			discards.add(c);
		}
		else {
			System.out.println("Can't Afford");
		}
		//discards.add(c);
	}
	/**
	 * Call this after you end your turn.
	 */
	public void cleanUp() {
		
	}
}
