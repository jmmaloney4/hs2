package hs.minion;

import hs.CardClass;
import hs.CardSet;

public class SenjinShieldmasta extends Minion {

	static final String Name = "Sen'jin Shieldmasta";
	static final int Cost = 5;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "Taunt";
	static final MinionRace Race = MinionRace.NEUTRAL;
	static final int Attack = 3;
	static final int Health = 5;
	static CardSet Set = CardSet.BASIC;

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

	@Override
	public CardSet getCardSet() {
		return Set;
	}
}
