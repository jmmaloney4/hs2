package hs.minion;

import hs.Card;

public abstract class Minion extends Card {
	
	int attack;
	int maxHealth;
	int health;
	
	static int Attack;
	static int Health;
	static MinionRace Race;
	
	public abstract int getNormalHealth();
	public abstract int getNormalAttack();
	
	public abstract int getCurrentHealth();
	public abstract int getCurrentAttack();
	public abstract int getMaxHealth();
	
}
