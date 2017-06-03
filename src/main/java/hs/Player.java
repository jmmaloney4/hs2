package hs;

import java.util.Arrays;

import hs.spell.TheCoin;

public class Player {

	Deck deck;
	int usedMana;
	int lockedMana;
	int toBeLockedMana;
	int mana;

	PlayerInterface iface;

	Card[] hand;
	Card[] board;
	
	Card[] getHand() {
		return hand;
	}
	
	Card[] getBoard() {
		return board;
	}

	public Player(PlayerInterface iface, Deck d) {
		this.iface = iface;
		this.deck = d;
	}

	public void StartGame(Game g, boolean p1) {
		iface.StartingGame(g);

		usedMana = 0;
		lockedMana = 0;
		toBeLockedMana = 0;
		mana = 0;

		hand = deck.MulliganHand(p1);
		iface.StartingMulligan(g, this, hand);
		
		/*
		for (int k = 0; k < hand.length; k++) {
			if (!iface.KeepCard(g, this, hand[k])) {
				Card oc = hand[k];
				hand[k] = deck.Draw();
				deck.AddCard(oc);
			}
		}
		 */
		
		// Give p2 the coin
		if (!p1) {
			hand = Arrays.copyOf(hand, hand.length + 1);
			hand[hand.length - 1] = new TheCoin();
		}

		iface.StartingHand(g, this, hand);
	}

	public void TakeTurn(Game g, int turn) {
		Card c = deck.Draw();
		iface.StartingTurn(g, this, turn, c);
		
		hand = Arrays.copyOf(hand, hand.length + 1);
		hand[hand.length - 1] = c;

		while (true) {
			PlayerAction action = iface.NextAction(g, this, turn);

			switch (action) {
			case PLAY_CARD:
				int i = iface.CardToPlayHandIndex(g, this, turn);
				System.out.println("Playing a " + this.hand[i].getName());
				
				Card[] nh = new Card[hand.length - 1];
				for (int k = 0; k < i; k++) {
					nh[k] = hand[k];
				}
				for (int k = i; k < nh.length; k++) {
					nh[k] = hand[k + 1];
				}
				
				hand = nh;
				
				break;
			case END_TURN:
				return;
			case HERO_COMBAT:
				break;
			case MINION_COMBAT:
				break;
			case USE_HERO_POWER:
				break;
			default:
				break;
			} 

		}

	}

}
