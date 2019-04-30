package dominion;


public abstract class Treasure implements Card {

	
	public Treasure() {
		
	}
	
	public String getName() {
		return "Treasure";
	}
	
	public int getAmount() {
		return 0;
	}
	
	public int getCost() {
		return 0;
	}
	
	public void activate(Player player) {
		
	}
	
	@Override
	public String toString() {
		return "(T) " + this.getName();
	}
	
	@Override
	public boolean equals(Object o) {
		return this.toString().equals(o.toString());
	}
}

