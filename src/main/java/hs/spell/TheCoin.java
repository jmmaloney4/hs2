package hs.spell;

import hs.CardClass;
import hs.CardType;

public class TheCoin extends Spell {
	
	static final String Name = "The Coin";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.PALADIN;
	static final String Text = "Gain 1 Mana Crystal this turn only.";
	
	@Override
	public String getName() {
		return Name;
	}

	@Override
	public int getNormalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardClass getCardClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardType getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
