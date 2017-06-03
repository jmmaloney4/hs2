package hs;

import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	Scanner scan;

	public HumanPlayer() {
		scan = new Scanner(System.in);
	}

	@Override
	public void StartingGame(Game g) {
		System.out.println("Starting Game");
	}

	@Override
	public void StartingMulligan(Game g, Player p, Card[] hand) {
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
	public boolean KeepCard(Game g, Player p, Card card) {
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
	public void StartingHand(Game g, Player p, Card[] hand) {
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
	public void StartingTurn(Game g, Player p, int turn, Card c) {
		System.out.println("Starting Turn " + turn % 2);
	}

	@Override
	public PlayerAction NextAction(Game g, Player p, int turn) {
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

	@Override
	public int CardToPlayHandIndex(Game g, Player p, int turn) {
		while (true) {
			System.out.println("Hand: " + p.getHand().length);
			for (int k = 0; k < p.getHand().length; k++) {
				System.out.println(k + " " + p.getHand()[k].getName());
			}

			String s = scan.nextLine();
			try {
				int i = Integer.parseInt(s);
				if (i < p.getHand().length) {
					return i;
				}
			} catch (NumberFormatException e) {
				// just try again
			}

		}
	}

}
