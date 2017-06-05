package hs.hero;

import hs.CardClass;
import hs.CardType;

public class Fireblast extends HeroPower {

	static String Name = "Fireblast";
	static int Cost = 2;
	static String Text = "Deal 1 Damage.";
	static CardClass Class = CardClass.MAGE;
	static CardType Type;
	
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
		return Type;
	}

}
