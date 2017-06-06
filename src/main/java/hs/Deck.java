// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import java.io.IOException;
import java.util.Arrays;

import hs.minion.BloodfenRaptor;

public class Deck {

	Card[] cards;
	Card[] drawn;
	
	Deck(String path) throws IOException {
		/*
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		*/
		
		this.cards = new Card[30];
		for (int k = 0; k < this.cards.length; k++) {
			this.cards[k] = new BloodfenRaptor();
		}
		
		this.drawn = new Card[0];
	}
	
	void shuffle() {
		
	}
	
	Card draw() {
		Card rv = this.cards[this.cards.length - 1];
		
		Card[] nc = Arrays.copyOf(this.cards, this.cards.length - 1);
		Card[] nd = Arrays.copyOf(this.drawn, this.drawn.length + 1);
		nd[this.drawn.length] = rv;
		
		this.cards = nc;
		this.drawn = nd;
		
		// System.out.println("Drew a " + rv.getName());
		
		return rv;
	}
	
	void addCard(Card c) {
		Card[] nc = Arrays.copyOf(this.cards, this.cards.length + 1);
		nc[this.cards.length] = c;
		this.cards = nc;
	}
	
	Card[] mulliganHand(boolean p1) {
		Card[] rv;
		
		rv = new Card[p1 ? 3 : 4];
		for (int k = 0; k < rv.length; k++) {
			rv[k] = this.draw();
		}
		
		return rv;
	}
	
}
