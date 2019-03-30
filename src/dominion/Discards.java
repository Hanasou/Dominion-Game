package dominion;

import java.util.*;

public class Discards extends ArrayList<Card>{

	
	public Discards() {
		
	}
	
	public void push(Card c) {
		this.add(c);
	}
	
	public void empty() {
		this.removeAll(this);
	}
}
