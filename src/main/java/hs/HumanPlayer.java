package hs;

import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	static Scanner scan = new Scanner(System.in);

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
		
		String[] options = {"Play Card", "Use Hero Power", "Minion Combat", "Hero Combat", "End Turn"};
		
		int i = HumanPlayer.GetOptionChoice(options, null);
		
		switch(i) {
		case 0:
			return PlayerAction.PLAY_CARD;
		case 1:
			return PlayerAction.USE_HERO_POWER;
		case 2:
			return PlayerAction.MINION_COMBAT;
		case 3:
			return PlayerAction.HERO_COMBAT;
		case 4:
			return PlayerAction.END_TURN;
		default:
			throw new IllegalStateException("Should not reach this default case, bad user input");
		}
	}

	@Override
	public int CardToPlayHandIndex(Game g, Player p, int turn) {

		String[] options = new String[p.getHand().length];
		// CardPlayability[] play = new CardPlayability[p.getHand().length];

		for (int k = 0; k < p.getHand().length; k++) {
			options[k] = p.getHand()[k].getName();
		}

		return GetOptionChoice(options, null);
	}

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static final String UNICODE_X = "\u2718"; // ✘
	public static final String UNICODE_CHECK = "\u2714"; // ✔
	public static final String UNICODE_ARROW = "\u00BB"; // »

	static int GetOptionChoice(String[] options, CardPlayability[] avaliable) {
		if ((avaliable != null) && (options.length != avaliable.length)) {
			return -1;
		}

		for (int k = 0; k < options.length; k++) {
			String line = String.format("%d", k);

			if (avaliable != null) {
				switch (avaliable[k]) {
				case NO:
					line += ANSI_RED + " " + UNICODE_X + ANSI_RESET; 
					break;
				case YES:
					line += ANSI_GREEN + " " + UNICODE_CHECK + ANSI_RESET;
					break;
				case WITH_EFFECT:
					line += ANSI_YELLOW + " " + UNICODE_ARROW + ANSI_RESET;
					break;
				default:
					break;
				}
			}

			line += (" " + options[k]);

			System.out.println(line);
		}

		int rv = -1;

		while (true) {
			System.out.print("[0-" + (options.length - 1) + "]: ");
			String s = scan.nextLine();
			try {
				int i = Integer.parseInt(s);
				if ((i >= 0) && (i < options.length)) {
					rv = i;
					break;
				}
			} catch (NumberFormatException e) {
				// just try again
			}
		}

		return rv;
	}

}
