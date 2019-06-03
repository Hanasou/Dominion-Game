package cards;

import dominion.Victory;

import javax.swing.ImageIcon;

import dominion.Player;

public class Curse extends Victory{

	public Curse() {
		
	}
	
	public String getName() {
		return "Curse";
	}
	
	public int getCost() {
		return 0;
	}
	
	public int getPoints() {
		return -1;
	}
	
	public void countPoints(Player player) {
		player.setVictory(player.getVictory() - 1);
	}
	
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/estate.png");
	}
}

