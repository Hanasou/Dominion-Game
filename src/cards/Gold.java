package cards;

import dominion.Treasure;
import dominion.Player;
import javax.swing.ImageIcon;

public class Gold extends Treasure{

	
	public Gold() {
		
	}
	
	public String getName() {
		return "Gold";
	}
	
	public int getCost() {
		return 6;
	}
	
	public int getAmount() {
		return 3;
	}
	
	@Override
	public void activate(Player player) {
		player.setMoney(player.getMoney() + 3);
	}
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/gold.png");
	}
	
}