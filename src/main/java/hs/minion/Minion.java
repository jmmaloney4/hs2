// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs.minion;

import hs.Card;
import hs.CardType;

public abstract class Minion extends Card {

	int attack;
	int maxHealth;
	int health;

	boolean playedThisTurn;
	int timesAttacked;

	static int Attack;
	static int Health;
	static MinionRace Race;

	public abstract int getNormalHealth();

	public abstract int getNormalAttack();

	public Minion() {
		attack = getNormalAttack();
		health = getNormalHealth();
		maxHealth = getNormalHealth();
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public CardType getType() {
		return CardType.MINION;
	}

	@Override
	public String toString() {
		return String.format("%s (%d Mana, %d/%d)", getName(), getCost(), getAttack(), getHealth());
	}

	public boolean canAttack() {
		if (timesAttacked == 0 && !playedThisTurn) {
			return true;
		} else {
			return false;
		}
	}
}
