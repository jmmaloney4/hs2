// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs.spell;

import hs.CardClass;
import hs.CardSet;

public class TheCoin extends Spell {

	static final String Name = "The Coin";
	static final int Cost = 0;
	static final CardClass Class = hs.CardClass.NEUTRAL;
	static final String Text = "Gain 1 Mana Crystal this turn only.";
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
	public CardSet getCardSet() {
		return Set;
	}
}
