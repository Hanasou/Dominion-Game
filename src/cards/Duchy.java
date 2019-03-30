package cards;

import dominion.Victory;

import javax.swing.ImageIcon;

import dominion.Player;

public class Duchy extends Victory{

	public Duchy() {
		
	}
	
	public String getName() {
		return "Duchy";
	}
	
	public int getCost() {
		return 5;
	}
	
	public void countPoints(Player player) {
		player.setVictory(player.getVictory() + 3);
	}
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/duchy.png");
	}
}
