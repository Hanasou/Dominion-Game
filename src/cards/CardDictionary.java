package cards;


import dominion.Card;
import java.util.HashMap;
/**
 * Hash map of all the cards. Associate them all with Strings so when I set up the board I don't have to make these things again.
 * @author Roy
 *
 */
public class CardDictionary extends HashMap<String, Card> {
	
	public CardDictionary() {
		put("Copper", new Copper());
		put("Silver", new Silver());
		put("Gold", new Gold());
		put("Estate", new Estate());
		put("Duchy", new Duchy());
		put("Province", new Province());
	}
}
