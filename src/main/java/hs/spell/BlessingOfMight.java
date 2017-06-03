package hs.spell;

import hs.CardClass;
import hs.CardType;

public class BlessingOfMight extends Spell {

	static final String Name = "Blessing of Might";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.PALADIN;
	static final String Text = "Give a minion +3 attack.";

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
