package hs.spell;

import hs.CardClass;

public class TheCoin extends Spell {
	
	static final String Name = "The Coin";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.PALADIN;
	static final String Text = "Gain 1 Mana Crystal this turn only.";
	
	@Override
	public String getName() {
		return Name;
	}
	
}
