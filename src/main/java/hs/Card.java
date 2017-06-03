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
}
