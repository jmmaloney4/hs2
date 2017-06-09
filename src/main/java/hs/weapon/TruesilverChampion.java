package hs.weapon;

import hs.CardClass;
import hs.CardSet;

public class TruesilverChampion extends Weapon {

	static final String Name = "Gurubashi Berserker";
	static final int Cost = 4;
	static final CardClass Class = CardClass.PALADIN;
	static final String Text = "Whenever your hero attacks, restore 2 Health to it.";
	static final int Attack = 4;
	static final int Durability = 2;
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
	public int getNormalDurability() {
		return Durability;
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
