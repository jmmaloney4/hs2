package hs;

public abstract class Player {

	Deck deck;
	int usedMana;
	int lockedMana;
	int toBeLockedMana;
	int mana;
	
	Card[] hand;
	
	void StartingGame(Game g) {}
	
	void StartingMulligan(Game g, Card[] hand) {}
	boolean KeepCard(Game g, Card c) { return true; }
	void StartingHand(Game g, Card[] hand) {}
	
	void StartingTurn(Game g, int turn, Card c) {}
	PlayerAction NextAction(Game g, int turn) { return null; }
}
