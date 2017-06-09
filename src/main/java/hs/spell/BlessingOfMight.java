// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs.spell;

import hs.CardClass;
import hs.CardSet;
import hs.CardType;

public class BlessingOfMight extends Spell {

	static final String Name = "Blessing of Might";
	static final int Cost = 1;
	static final CardClass Class = hs.CardClass.PALADIN;
	static final String Text = "Give a minion +3 attack.";
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
	public CardType getType() {
		return CardType.SPELL;
	}
	
	@Override
	public CardSet getCardSet() {
		return Set;
	}
}
