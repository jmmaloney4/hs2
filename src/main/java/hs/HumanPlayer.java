package hs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {
	
	HumanPlayer(Deck d) {
		this.deck = d;
	}
	
	@Override
	void StartingGame(Game g) {
		System.out.println("Starting Game");
	}
	
	@Override
	void StartingMulligan(Game g, Card[] hand) {
		System.out.print("Starting Hand: [");
		for (int k = 0; k < hand.length; k++) {
			System.out.print(hand[k].getName());
			if ((k + 1) < hand.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	@Override
	boolean KeepCard(Game g, Card card) {
		System.out.print("Keep " + card.getName() + "? ");
		// System.out.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			if (s.startsWith("Y") || s.startsWith("Y")) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
