package hs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import hs.minion.BloodfenRaptor;

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
	
	Card[] MulliganHand(boolean p1) {
		Card[] rv;
		
		rv = new Card[p1 ? 3 : 4];
		for (int k = 0; k < rv.length; k++) {
			rv[k] = this.Draw();
		}
		
		return rv;
	}
	
}
