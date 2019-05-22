package dominion;

import java.util.*;
public class Hand extends ArrayList<Card>{

	
	public Hand() {
		
	}
	
	public void empty() {
		this.removeAll(this);
	}
}
