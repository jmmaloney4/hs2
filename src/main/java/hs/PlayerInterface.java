package hs;

public interface PlayerInterface {
	
	void StartingGame(Game g);

	void StartingMulligan(Game g, Player p, Card[] hand);
	boolean KeepCard(Game g, Player p, Card c);
	void StartingHand(Game g, Player p, Card[] hand);

	void StartingTurn(Game g, Player p, int turn, Card c);
	PlayerAction NextAction(Game g, Player p, int turn);

	int CardToPlayHandIndex(Game g, Player p, int turn);

}
