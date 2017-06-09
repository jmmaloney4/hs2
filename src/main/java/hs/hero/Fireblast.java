// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs.hero;

import hs.CardClass;
import hs.CardSet;
import hs.CardType;

public class Fireblast extends HeroPower {

	static String Name = "Fireblast";
	static int Cost = 2;
	static String Text = "Deal 1 Damage.";
	static CardClass Class = CardClass.MAGE;
	static CardType Type;
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
		return Type;
	}

	@Override
	public CardSet getCardSet() {
		return Set;
	}

}
