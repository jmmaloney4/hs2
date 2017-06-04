package hs.spell;

import hs.CardClass;
import hs.CardType;

public class TheCoin extends Spell {
	
	static final String Name = "The Coin";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.NEUTRAL;
	static final String Text = "Gain 1 Mana Crystal this turn only.";
	
	@Override
	public String getName() {
		return Name;
	}

	@Override
	public int getNormalCost() {
		return Cost;
	}

	@Override
	public String getText() {
		return Text;
	}

	@Override
	public CardClass getCardClass() {
		return Class;
	}

	@Override
	public CardType getType() {
		return CardType.SPELL;
	}
	
}
