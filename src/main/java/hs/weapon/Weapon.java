package hs.weapon;

import hs.Card;

public abstract class Weapon extends Card {

	int attack;
	int durability;

	public abstract int getNormalAttack();

	public abstract int getNormalDurability();

	public int getAttack() {
		return attack;
	}

	public int getDurability() {
		return durability;
	}

	@Override
	public String toString() {
		return String.format("%s (%d Mana, %d/%d) [%s]", getName(), getCost(), getAttack(), getDurability(), getText());
	}
}
