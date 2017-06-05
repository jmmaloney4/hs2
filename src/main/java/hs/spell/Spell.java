package hs.spell;

import hs.Card;
import hs.CardType;

public abstract class Spell extends Card {
	
	@Override
	public CardType getType() {
		return CardType.SPELL;
	}
}
