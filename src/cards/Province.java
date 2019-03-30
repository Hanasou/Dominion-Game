package cards;

import dominion.Victory;

import javax.swing.ImageIcon;

import dominion.Player;

public class Province extends Victory{

	public Province() {
		
	}
	
	public String getName() {
		return "Province";
	}
	
	public int getCost() {
		return 8;
	}
	
	public void countPoints(Player player) {
		player.setVictory(player.getVictory() + 6);
	}
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/province.png");
	}
}
