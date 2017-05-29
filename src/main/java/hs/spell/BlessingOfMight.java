package hs.spell;

import hs.CardClass;

public class BlessingOfMight extends Spell {

	static final String Name = "Blessing of Might";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.PALADIN;
	static final String Text = "Give a minion +3 attack.";

	@Override
	public String getName() {
		return Name;
	}
	
}
