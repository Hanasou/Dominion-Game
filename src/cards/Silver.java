package cards;

import dominion.Treasure;
import java.awt.Image;

import javax.swing.ImageIcon;

import dominion.Player;

public class Silver extends Treasure{
	
	public Silver() {
	}
	
	public String getName() {
		return "Silver";
	}
	
	public int getCost() {
		return 3;
	}
	
	public int getAmount() {
		return 2;
	}
	
	@Override
	public void activate(Player player) {
		player.setMoney(player.getMoney() + 2);
	}
	
	public ImageIcon getImageIcon() {
		return new ImageIcon("card_img/silver.png");
	}
}
