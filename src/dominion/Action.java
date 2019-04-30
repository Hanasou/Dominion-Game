package dominion;

public abstract class Action implements Card {

	
	public Action() {
		
	}
	
	public String getName() {
		return "Action";
	}
	
	public int getCost() {
		return 0;
	}
	
	public String getDesc() {
		return null;
	}
	
	/**
	 * Method gets called when played.
	 */
	public void activate(Player player) {
		
	}
	
	public String toString() {
		return "(A) " + this.getName();
	}
}