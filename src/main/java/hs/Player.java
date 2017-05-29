package hs;

public abstract class Player {

	Deck deck;
	
	void StartingGame(Game g) {}
	
	void StartingMulligan(Game g, Card[] hand) {}
	boolean KeepCard(Game g, Card c) { return true; }
	
}
