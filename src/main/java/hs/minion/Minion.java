package hs.minion;

import hs.Card;
import hs.CardType;

public abstract class Minion extends Card {
	
	int attack;
	int maxHealth;
	int health;
	
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
}
