// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

public abstract class Card {

	static String Name;
	static int Cost;
	static String Text;
	static CardClass Class;
	static CardType Type;

	int cost;

	public abstract String getName();

	public abstract int getNormalCost();

	public abstract String getText();

	public abstract CardClass getCardClass();

	public abstract CardType getType();

	public Card() {
		cost = getNormalCost();
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return String.format("%s (%d Mana)", getName(), getCost());
	}

	public CardPlayability getPlayabilityInCurrentState(Game g, Player p) {
		if (p.mana >= getCost()) {
			return CardPlayability.YES;
		} else {
			return CardPlayability.NO;
		}
	}
}
