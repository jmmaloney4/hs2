package hs.minion;

import hs.CardClass;

public class BloodfenRaptor extends Minion {

	static final String Name = "Bloodfen Raptor";
	static final int Cost = 2;
	static final CardClass Class = CardClass.NEUTRAL;
	static final String Text = "";
	static final MinionRace Race = MinionRace.BEAST;
	static final int Attack = 3;
	static final int Health = 2;
	
	
	public BloodfenRaptor() {
		this.attack = Attack;
		this.health = Health;
	}
	
	@Override
	public String getName() {
		return Name;
	}
	
}
