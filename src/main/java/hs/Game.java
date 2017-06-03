package hs;

import java.util.Arrays;

import hs.spell.TheCoin;

public class Game {
	
	Player p1;
	Player p2;
	
	int turn;
	
	Game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void Start() {
		
		p1.StartGame(this, true);
		p2.StartGame(this, false);
		
		/*
		this.p1.StartingGame(this);
		this.p2.StartingGame(this);
		
		this.p1.deck.Shuffle();
		this.p2.deck.Shuffle();
		
		// see classes
		
		Card[] p1m = this.p1.deck.MulliganHand(true);
		Card[] p2m = this.p2.deck.MulliganHand(false);
		
		p1.StartingMulligan(this, p1m);
		p2.StartingMulligan(this, p2m);
		
		//this.RunMulligan(p1, p1m);
		//this.RunMulligan(p2, p2m);
		
		// Give p2 the coin
		p2m = Arrays.copyOf(p2m, p2m.length + 1);
		p2m[p2m.length - 1] = new TheCoin();
		
		p1.StartingHand(this, p1m);
		p2.StartingHand(this, p2m);
		*/
		
		p2.TakeTurn(this, 0);
	}
	
}
