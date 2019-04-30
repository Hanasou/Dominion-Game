package cards;

import dominion.Treasure;
import javax.swing.ImageIcon;
import dominion.Player;

public class Copper extends Treasure{

	
	public Copper() {
	}
	
	public String getName() {
		return "Copper";
	}
	
	public int getCost() {
		return 0;
	}
	
	public int getAmount() {
		return 1;
	}
	
	@Override
	public void activate(Player player) {
		player.setMoney(player.getMoney() + 1);
	}
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/copper.png");
	}
}