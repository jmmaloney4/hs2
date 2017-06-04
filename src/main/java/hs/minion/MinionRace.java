package hs.minion;

public enum MinionRace {

	BEAST("Beast"),
	DRAGON("Dragon"),
	ELEMENTAL("Elemental"),
	MURLOC("Murloc"),
	NEUTRAL("Neutral");
	
	String name;
	
	MinionRace(String name) {
		this.name = name;
	}
	
}
