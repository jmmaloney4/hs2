package hs.minion;

import hs.CardClass;
import hs.CardSet;

public class GurubashiBerserker extends Minion {

	static final String Name = "Gurubashi Berserker";
	static final int Cost = 5;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "Whenever this minion takes damage, gain +3 Attack.";
	static final MinionRace Race = MinionRace.NEUTRAL;
	static final int Attack = 2;
	static final int Health = 7;
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
