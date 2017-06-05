package hs.minion;

import hs.CardClass;

public class BloodfenRaptor extends Minion {

	static final String Name = "Bloodfen Raptor";
	static final int Cost = 2;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "";
	static final MinionRace Race = MinionRace.BEAST;
	static final int Attack = 3;
	static final int Health = 2;
	
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
	public int getNormalHealth() {
		return Health;
	}

	@Override
	public int getNormalAttack() {
		return Attack;
	}	
}
