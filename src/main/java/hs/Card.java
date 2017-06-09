// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import event.Event;
import event.Listener;
import hs.hero.Hero;
import hs.hero.HeroPower;
import hs.minion.Minion;
import hs.spell.Spell;
import hs.weapon.Weapon;

public abstract class Card implements Listener {

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

	public CardType getType() {
		if (this instanceof Minion) {
			return CardType.MINION;
		} else if (this instanceof Spell) {
			return CardType.SPELL;
		} else if (this instanceof Weapon) {
			return CardType.WEAPON;
		} else if (this instanceof HeroPower) {
			return CardType.HERO_POWER;
		} else if (this instanceof Hero) {
			return CardType.HERO;
		} else {
			throw new IllegalStateException("Unknown card type");
		}
	}

	public Card() {
		cost = getNormalCost();
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return String.format("%s (%d Mana) [%s]", getName(), getCost(), getText());
	}

	public CardPlayability getPlayabilityInCurrentState(Game g, Player p) {
		if (p.mana >= getCost()) {
			return CardPlayability.YES;
		} else {
			return CardPlayability.NO;
		}
	}

	public void listen(Event e) {

	}
}
