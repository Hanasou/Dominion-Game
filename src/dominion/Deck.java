package dominion;

import java.util.*;
import cards.*;
public class Deck extends ArrayList<Card>{

	public Deck() {
		for (int i = 0; i < 10; i++) {
			if (i < 7) {
				add(new Copper());
			}
			else {
				add(new Estate());
			}
		}
		Collections.shuffle(this);
	}
	
	public Card pop() {
		return this.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(this);
	}
}

