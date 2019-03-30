package dominion;

import javax.swing.ImageIcon;

public interface Card{

	String getName();
	int getCost();
	void activate(Player player);
	ImageIcon getImageIcon();
	String toString();
	
}
