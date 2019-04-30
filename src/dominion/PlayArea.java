package dominion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import cards.*;

public class PlayArea extends JPanel{

	private JLabel actions;
	private JLabel buys;
	private JLabel money;
	private DefaultListModel<Card> inPlayList;
	private JList<Card> inPlay;
	private DefaultListModel<Card> handList;
	private JList<Card> hand;
	
	public PlayArea() {
		this.inPlayList = new DefaultListModel<Card>();
		this.inPlay = new JList<Card>(inPlayList);
		this.handList = new DefaultListModel<Card>();
		this.hand = new JList<Card>(handList);
		
		this.actions = new JLabel("1");
		this.buys = new JLabel("1");
		this.money = new JLabel("0");
		
		setLayout(new FlowLayout());
		
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
		inPlayPanel.setLayout(new BorderLayout());
		inPlayPanel.add(new JLabel("In Play"), BorderLayout.NORTH);
		//inPlay.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		inPlayPanel.add(inPlayScroll, BorderLayout.CENTER);
		
		JPanel playPanel = new JPanel();
		JScrollPane handScroll = new JScrollPane(hand);
		playPanel.setLayout(new BorderLayout());
		playPanel.add(new JLabel("Hand"), BorderLayout.NORTH);
		playPanel.add(handScroll);
		
		add(infoPanel);
		add(inPlayPanel);
		add(playPanel);
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
}
