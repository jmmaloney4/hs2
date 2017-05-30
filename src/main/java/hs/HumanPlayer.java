package hs;

import java.util.Scanner;

public class HumanPlayer extends Player {

	Scanner scan;

	HumanPlayer(Deck d) {
		scan = new Scanner(System.in);
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
		while (true) {
			System.out.print("Keep " + card.getName() + "? ");
			System.out.flush();

			String s = scan.nextLine();

			if (s.startsWith("y") || s.startsWith("Y")) {
				return true;
			} else if (s.startsWith("n") || s.startsWith("N")) {
				return false;
			}
		}
	}

}
