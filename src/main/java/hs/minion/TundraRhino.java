package hs.minion;

import hs.CardClass;

public class TundraRhino extends Minion {

	static final String Name = "Tundra Rhino";
	static final int Cost = 5;
	static final CardClass Class = CardClass.HUNTER;
	static final String Text = "Your Beasts have Charge.";
	static final MinionRace Race = MinionRace.BEAST;
	static final int Attack = 2;
	static final int Health = 5;

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
