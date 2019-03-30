package dominion;

import javax.swing.*;
import java.awt.*;
public class PlayArea extends JPanel{

	private JLabel actions;
	private JLabel buys;
	private JLabel money;
	
	public PlayArea() {
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
		
		add(infoPanel);
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
}
