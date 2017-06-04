package hs;

import java.util.Scanner;


public class HumanPlayer implements PlayerInterface {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_CLEAR = "\033[2J\033[;H";

	public static final String UNICODE_X = "\u2718"; // ✘
	public static final String UNICODE_CHECK = "\u2714"; // ✔
	public static final String UNICODE_ARROW = "\u00BB"; // »
	
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
		System.out.println("Mulligan Hand: " + handToString(hand));
	}

	@Override
	public boolean KeepCard(Game g, Player p, Card card) {
		return getBooleanChoice("Keep " + card.toString());
	}

	@Override
	public void StartingHand(Game g, Player p, Card[] hand) {
		System.out.println("Starting Hand: " + handToString(hand));
	}

	@Override
	public void StartingTurn(Game g, Player p, int turn, Card c) {
		System.out.println("Starting Turn " + turn % 2);
	}

	@Override
	public PlayerAction NextAction(Game g, Player p, int turn) {

		String[] options = {"Play Card", "Use Hero Power", "Minion Combat", "Hero Combat", "End Turn"};

		int i = HumanPlayer.getOptionChoice(options, null);

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
			options[k] = p.getHand()[k].toString();
		}

		return getOptionChoice(options, null);
	}

	// TODO: Don't allow users to choose an option that is CardPlayability.NO
	static int getOptionChoice(String[] options, CardPlayability[] avaliable) {
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
					if (avaliable != null && avaliable[i] == CardPlayability.NO) {
						continue;
					}
					rv = i;
					break;
				}
			} catch (NumberFormatException e) {
				// just try again
			}
		}

		return rv;
	}

	static boolean getBooleanChoice(String question) {
		while (true) {
			System.out.print(question + "? [y/n]: ");
			String s = scan.nextLine();

			if (s.startsWith("y") || s.startsWith("Y")) {
				return true;
			} else if (s.startsWith("n") || s.startsWith("N")) {
				return false;
			}
		}
	}
	
	static String handToString(Card[] hand) {
		String s = "[";
		for (int k = 0; k < hand.length; k++) {
			s += hand[k].toString();
			if ((k + 1) < hand.length) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
}
