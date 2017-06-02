package hs;

import java.util.Arrays;
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
		System.out.print("Mulligan Hand: [");
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

	@Override
	void StartingHand(Game g, Card[] hand) {
		System.out.print("Starting Hand: [");
		for (int k = 0; k < hand.length; k++) {
			System.out.print(hand[k].getName());
			if ((k + 1) < hand.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		this.hand = hand.clone();
	}

	@Override
	void StartingTurn(Game g, int turn, Card c) {
		System.out.println("Starting Turn " + turn % 2);
		this.hand = Arrays.copyOf(this.hand, this.hand.length + 1);
		this.hand[this.hand.length - 1] = c;
	}

	@Override
	PlayerAction NextAction(Game g, int turn) {
		while (true) {
			System.out.println("Play Card: 1");
			System.out.println("Use Hero Power: 2");
			System.out.println("Minion Combat: 3");
			System.out.println("Hero Combat: 4");
			System.out.println("End Turn: 5");

			String s = scan.nextLine();
			try {
				int i = Integer.parseInt(s);
				
				switch(i) {
				case 1:
					return PlayerAction.PLAY_CARD;
				case 2:
					return PlayerAction.USE_HERO_POWER;
				case 3:
					return PlayerAction.MINION_COMBAT;
				case 4:
					return PlayerAction.HERO_COMBAT;
				case 5:
					return PlayerAction.END_TURN;
				}
				
			} catch (NumberFormatException e) {
				// just try again
			}
		}
	}

}
