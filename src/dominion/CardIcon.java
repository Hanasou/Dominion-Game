package dominion;

import javax.swing.*;
import java.awt.Image;

public class CardIcon extends ImageIcon{

	private String cardName;
	
	public CardIcon(String cardName, String image) {
		super(image);
		this.cardName = cardName;
	}
	
	public String getCardName() {
		return cardName;
	}
}

