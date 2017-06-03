package hs;

public abstract class Player {

	Deck deck;
	int usedMana;
	int lockedMana;
	int toBeLockedMana;
	int mana;
	
	Card[] hand;
	
	abstract void StartingGame(Game g);
	
	abstract void StartingMulligan(Game g, Card[] hand);
	abstract boolean KeepCard(Game g, Card c);
	abstract void StartingHand(Game g, Card[] hand);
	
	abstract void StartingTurn(Game g, int turn, Card c);
	abstract PlayerAction NextAction(Game g, int turn);
	
	abstract Card CardToPlay(Game g, int turn);
}
