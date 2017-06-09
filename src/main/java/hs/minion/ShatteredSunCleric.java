package hs.minion;

import hs.CardClass;
import hs.CardSet;

public class ShatteredSunCleric extends Minion {

	static final String Name = "Shattered Sun Cleric";
	static final int Cost = 3;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "Battlecry: Give a friendly minion +1/+1.";
	static final MinionRace Race = MinionRace.NEUTRAL;
	static final int Attack = 3;
	static final int Health = 2;
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
