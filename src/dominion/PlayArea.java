package dominion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import cards.*;
/**
 * The play area that is associated with the player.
 * Every player has their own play area. When the player ends their turn, the play area gets swapped to another player's.
 * Contains all the information players need to take their turn and provides them the ability to do so.
 * @author Roy
 *
 */
public class PlayArea extends JPanel{

	private ArrayList<Player> players;
	private Player currPlayer;
	private JLabel actions;
	private JLabel buys;
	private JLabel money;
	private DefaultListModel<Card> inPlayList;
	private JList<Card> inPlay;
	private DefaultListModel<Card> handList;
	private JList<Card> hand;
	private DefaultListModel<Card> discardList;
	private JList<Card> discards;
	private JLabel turnLabel;
	private int playerNum;
	
	public PlayArea(ArrayList<Player> players) {
		//Initialize everything
		this.players = players;
		this.inPlayList = new DefaultListModel<Card>();
		this.inPlay = new JList<Card>(inPlayList);
		this.handList = new DefaultListModel<Card>();
		this.hand = new JList<Card>(handList);
		this.discardList = new DefaultListModel<Card>();
		this.discards = new JList<Card>(discardList);
		this.currPlayer = players.get(playerNum);
		this.turnLabel = new JLabel(currPlayer.getName() + "'s Turn");
		
		this.actions = new JLabel();
		this.buys = new JLabel();
		this.money = new JLabel();
		
		setLayout(new FlowLayout());
		
		//Displays the player's information
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0,2,1,3));
		infoPanel.add(new JLabel("Actions:"));
		infoPanel.add(actions);
		infoPanel.add(new JLabel("Buys:"));
		infoPanel.add(buys);
		infoPanel.add(new JLabel("Money:"));
		infoPanel.add(money);
		
		JPanel inPlayPanel = new JPanel();
		JScrollPane inPlayScroll = new JScrollPane(inPlay);
		inPlayScroll.setPreferredSize(new Dimension(75,150));
		inPlayPanel.setLayout(new BorderLayout());
		inPlayPanel.add(turnLabel, BorderLayout.NORTH);
		inPlayPanel.add(inPlayScroll, BorderLayout.CENTER);
		
		JPanel handPanel = new JPanel();
		JScrollPane handScroll = new JScrollPane(hand);
		handScroll.setPreferredSize(new Dimension(75,150));
		handPanel.setLayout(new BorderLayout());
		handPanel.add(new JLabel("Hand"), BorderLayout.NORTH);
		handPanel.add(handScroll, BorderLayout.CENTER);
		
		JPanel discardPanel = new JPanel();
		JScrollPane discardScroll = new JScrollPane(discards);
		discardScroll.setPreferredSize(new Dimension(75,150));
		discardPanel.setLayout(new BorderLayout());
		discardPanel.add(new JLabel("Discards"), BorderLayout.NORTH);
		discardPanel.add(discardScroll, BorderLayout.CENTER);
		
		JPanel actionPanel = new JPanel();
		JButton playButton = new JButton("Play");
		JButton endButton = new JButton("End Turn");
		JButton endActions = new JButton("End Actions");
		JButton playTreasures = new JButton("Play Treasures");
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getTurn());
				//System.out.println(hand.getSelectedValue());
				currPlayer.play(hand.getSelectedValue());
				updateView();
			}
		});
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getTurn());
				swapPlayers();
			}
		});
		endActions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer.endActions();
			}
		});
		playTreasures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getTurn());
				//System.out.println(hand.getSelectedValue());
				currPlayer.playTreasures();
				updateView();
			}
		});
		actionPanel.setLayout(new GridLayout(4,0,1,3));
		actionPanel.add(playButton);
		actionPanel.add(playTreasures);
		actionPanel.add(endActions);
		actionPanel.add(endButton);
		
		
		
		add(infoPanel);
		add(inPlayPanel);
		add(handPanel);
		add(discardPanel);
		add(actionPanel);
		
		updateView();
	}
	
	public Player getCurrPlayer() {
		return currPlayer;
	}
	
	public void swapPlayers() {
		if (currPlayer == players.get(0)) {
			currPlayer = players.get(1);
		}
		else {
			currPlayer = players.get(0);
		}
		currPlayer.resetTurn();
		updateView();
		turnLabel.setText(currPlayer.getName() + "'s Turn");
	}
	public void setActions(int a) {
		actions.setText(((Integer) a).toString());
	}
	
	public void setBuys(int b) {
		buys.setText(((Integer) b).toString());
	}
	
	public void setMoney(int m) {
		money.setText(((Integer) m).toString());
	}

	public void addInPlay(Card c) {
		inPlayList.addElement(c);
	}
	
	public void addHand(Card c) {
		handList.addElement(c);
	}
	
	public void addDiscard(Card c) {
		discardList.addElement(c);
	}
	
	public void emptyHand() {
		handList.clear();
	}
	
	public void emptyDiscard() {
		discardList.clear();
	}
	
	public void emptyInPlay() {
		inPlayList.clear();
	}
	
	public void addHandAll() {
		for (Card c : currPlayer.getHand()) {
			addHand(c);
		}
	}
	
	public void addDiscardAll() {
		for (Card c : currPlayer.getDiscards()) {
			addDiscard(c);
		}
	}
	
	public void addInPlayAll() {
		for (Card c : currPlayer.getInPlay()) {
			addInPlay(c);
		}
	}
	/**
	 * Add all the cards in the player's hand to the view.
	 */
	public void updateView() {
		setActions(currPlayer.getActions());
		setBuys(currPlayer.getBuys());
		setMoney(currPlayer.getMoney());
		emptyHand();
		emptyDiscard();
		emptyInPlay();
		addHandAll();
		addDiscardAll();
		addInPlayAll();
	}
}
