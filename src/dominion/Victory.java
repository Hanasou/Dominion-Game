package dominion;

import javax.swing.ImageIcon;

public abstract class Victory implements Card {

	public Victory() {
		
	}
	
	public String getName() {
		return "Victory";
	}
	
	public int getPoints() {
		return 0;
	}
	
	public int getCost() {
		return 0;
	}
	
	
	public void activate(Player player) {
		
	}
	
	public String toString() {
		return "(V) " + this.getName();
	}
}

