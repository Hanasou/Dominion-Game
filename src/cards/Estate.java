package cards;

import dominion.Victory;

import javax.swing.ImageIcon;

import dominion.Player;

public class Estate extends Victory{

	public Estate() {
		
	}
	
	public String getName() {
		return "Estate";
	}
	
	public int getCost() {
		return 2;
	}
	
	public void countPoints(Player player) {
		player.setVictory(player.getVictory() + 1);
	}
	
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/estate.png");
	}
}
