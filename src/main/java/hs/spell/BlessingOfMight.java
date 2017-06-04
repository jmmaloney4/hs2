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
