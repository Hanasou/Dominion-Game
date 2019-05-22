package dominion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import cards.*;
/**
 * The play area that is associated with the player.
 * Every player has their own play area. When the player ends their turn, the play area gets swapped to another player's.
 * Contains all the information players need to take their turn and provides them the ability to do so.
 * @author Roy
 *
 */
public class PlayArea extends JPanel{

	private String playerName;
	private JLabel actions;
	private JLabel buys;
	private JLabel money;
	private DefaultListModel<Card> inPlayList;
	private JList<Card> inPlay;
	private DefaultListModel<Card> handList;
	private JList<Card> hand;
	private DefaultListModel<Card> discardList;
	private JList<Card> discards;
	private boolean turn;
	
	public PlayArea(String playerName) {
		//Initialize everything
		this.inPlayList = new DefaultListModel<Card>();
		this.inPlay = new JList<Card>(inPlayList);
		this.handList = new DefaultListModel<Card>();
		this.hand = new JList<Card>(handList);
		this.discardList = new DefaultListModel<Card>();
		this.discards = new JList<Card>(discardList);
		
		this.turn = true;
		this.playerName = playerName;
		
		this.actions = new JLabel("1");
		this.buys = new JLabel("1");
		this.money = new JLabel("0");
		
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
		inPlayPanel.add(new JLabel("In Play"), BorderLayout.NORTH);
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
		JButton endButton = new JButton("End");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(getTurn());
				//System.out.println(hand.getSelectedValue());
			}
		});
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTurn(false);
				//System.out.println(getTurn());
			}
		});
		actionPanel.setLayout(new FlowLayout());
		actionPanel.add(playButton);
		actionPanel.add(endButton);
		
		add(infoPanel);
		add(inPlayPanel);
		add(handPanel);
		add(discardPanel);
		add(actionPanel);
		
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setActions(int a) {
		actions.setText(((Integer) a).toString());
	}
	
	public void setBuys(int b) {
		buys.setText(((Integer) b).toString());
	}
	
	public void setMoney(int m) {
		actions.setText(((Integer) m).toString());
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
	
	public void setTurn(boolean b) {
		this.turn = b;
	}
	
	public void setPlayerName(String name) {
		this.playerName = name;
	}
}
