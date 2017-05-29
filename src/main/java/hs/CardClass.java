package hs;

public enum CardClass {
	
	NEUTRAL("Neutral"),
	
	DRUID("Druid"),
	HUNTER("Hunter"),
	MAGE("Mage"),
	PALADIN("Paladin"),
	PRIEST("Priest"),
	ROUGE("Rouge"),
	SHAMAN("Shaman"),
	WARLOCK("Warlock"),
	WARRIOR("Warrior");
	
	String name;
	
	CardClass(String name) {
		this.name = name;
	}
}
