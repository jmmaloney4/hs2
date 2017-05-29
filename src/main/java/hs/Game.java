package hs;

import java.util.Arrays;

public class Game {

	Player p1;
	Player p2;
	
	Game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void Start() {
		this.p1.StartingGame(this);
		this.p2.StartingGame(this);
		
		this.p1.deck.Shuffle();
		this.p2.deck.Shuffle();
		
		Card[] p1m = this.p1.deck.Mulligan(true);
		Card[] p2m = this.p2.deck.Mulligan(false);
		
		p1.StartingMulligan(this, p1m);
		p2.StartingMulligan(this, p2m);
		
		for (int k = 0; k < p1m.length; k++) {
			if (!p1.KeepCard(this, p1m[k])) {
				Card oc = p1m[k];
				p1m[k] = p1.deck.Draw();
				p1.deck.AddCard(oc);
			}
		}
	}
	
}
