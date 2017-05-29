package hs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import hs.minion.BloodfenRaptor;
import hs.spell.TheCoin;

public class Deck {

	Card[] cards;
	Card[] drawn;
	
	Deck(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
		this.cards = new Card[30];
		for (int k = 0; k < this.cards.length; k++) {
			this.cards[k] = new BloodfenRaptor();
		}
		
		this.drawn = new Card[0];
		
		reader.close();
	}
	
	void Shuffle() {
		
	}
	
	Card Draw() {
		Card rv = this.cards[this.cards.length - 1];
		
		Card[] nc = Arrays.copyOf(this.cards, this.cards.length - 1);
		Card[] nd = Arrays.copyOf(this.drawn, this.drawn.length + 1);
		nd[this.drawn.length] = rv;
		
		this.cards = nc;
		this.drawn = nd;
		
		System.out.println("Drew a " + rv.getName());
		
		return rv;
	}
	
	void AddCard(Card c) {
		Card[] nc = Arrays.copyOf(this.cards, this.cards.length + 1);
		nc[this.cards.length] = c;
		this.cards = nc;
	}
	
	Card[] Mulligan(boolean p1) {
		Card[] rv;
		int len;
		if (p1) {
			len = 3;
		} else {
			len = 4;
		}
		
		rv = new Card[len];
		for (int k = 0; k < len; k++) {
			rv[k] = this.Draw();
		}
		
		if (!p1) {
			Card[] nrv = Arrays.copyOf(rv, rv.length + 1);
			nrv[rv.length] = new TheCoin();
			rv = nrv;
		}
		
		return rv;
	}
	
}