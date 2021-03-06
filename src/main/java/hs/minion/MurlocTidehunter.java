package hs.minion;

import hs.CardClass;
import hs.CardSet;

public class MurlocTidehunter extends Minion {

	static final String Name = "Murloc Tidehunter";
	static final int Cost = 2;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "Battlecry: Summon a 1/1 Murloc Scout.";
	static final MinionRace Race = MinionRace.MURLOC;
	static final int Attack = 2;
	static final int Health = 1;
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
