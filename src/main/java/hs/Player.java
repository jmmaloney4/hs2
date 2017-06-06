// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import java.util.Arrays;

import hs.hero.Fireblast;
import hs.minion.Minion;
import hs.spell.TheCoin;

public class Player {

	Deck deck;

	int mana;
	int usedMana;
	int manaCrystals;
	int bonusMana;
	int lockedMana;
	int overloadedMana;

	int getManaCrystals() {
		return manaCrystals;
	}

	int getAvaliableMana() {
		return mana;
	}

	int getLockedMana() {
		return lockedMana;
	}

	int getOverloadedMana() {
		return overloadedMana;
	}

	int getUsedMana() {
		return usedMana;
	}

	int getBonusMana() {
		return bonusMana;
	}

	void manaNextTurn() {
		if (manaCrystals < 10) {
			manaCrystals += 1;
		}
		mana = manaCrystals;
		usedMana = 0;
		bonusMana = 0;
		lockedMana = overloadedMana;
		mana -= lockedMana;
		overloadedMana = 0;
	}

	void spendMana(int i) {
		if (i > getAvaliableMana()) {
			throw new IllegalArgumentException(String.format("Cannot spend %d mana, only have %d avaliable", i, getAvaliableMana()));
		}
		mana -= i;
		usedMana += i;
	}

	void overloadMana(int o) {
		overloadedMana += o;
	}

	CardClass heroClass;
	Card heroPower;
	boolean usedHeroPower;

	boolean hasUsedHeroPower() {
		return usedHeroPower;
	}

	Card getHeroPower() {
		return heroPower;
	}

	CardClass getHeroClass() {
		return heroClass;
	}

	PlayerInterface iface;

	Card[] hand;
	Minion[] board;

	Card[] getHand() {
		return hand;
	}

	Minion[] getBoard() {
		return board;
	}

	Card pullCardFromHand(int index) {
		Card rv = hand[index];

		Card[] nh = new Card[hand.length - 1];
		for (int k = 0; k < index; k++) {
			nh[k] = hand[k];
		}
		for (int k = index; k < nh.length; k++) {
			nh[k] = hand[k + 1];
		}
		hand = nh;

		return rv;
	}

	void addCardToHand(Card c) {
		hand = Arrays.copyOf(hand, hand.length + 1);
		hand[hand.length - 1] = c;
	}

	void insertMinionOntoBoard(Minion m, int index) {
		if ((index < 0) || (index > getBoard().length)) {
			throw new IndexOutOfBoundsException(String.format("%d out of bounds for board size %d", index, getBoard().length));
		}

		Minion[] nb = new Minion[getBoard().length + 1]; 
		for (int k = 0; k < index; k++) {
			nb[k] = getBoard()[k];
		}
		nb[index] = m;
		for (int k = index + 1; k < nb.length; k++) {
			nb[k] = getBoard()[k - 1];
		}

		board = nb;
	}

	public Player(PlayerInterface iface, Deck d, CardClass cls) {
		this.iface = iface;
		this.deck = d;

		this.heroClass = cls;
		this.heroPower = new Fireblast();

		this.board = new Minion[0];
	}

	public void startGame(Game g, boolean p1) {
		iface.startingGame(g);

		mana = 0;
		usedMana = 0;
		manaCrystals = 0;
		bonusMana = 0;
		lockedMana = 0;
		overloadedMana = 0;

		usedHeroPower = false;

		hand = deck.mulliganHand(p1);
		iface.startingMulligan(g, this, hand);

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

		iface.startingHand(g, this, hand);
	}

	public void takeTurn(Game g, int turn) {
		manaNextTurn();

		Card c = deck.draw();
		iface.startingTurn(g, this, turn, c);

		while (true) {
			PlayerAction action = iface.nextAction(g, this, turn);

			switch (action) {
			case PLAY_CARD:
				int i = iface.cardToPlayHandIndex(g, this, turn);
				if (getHand()[i].getPlayabilityInCurrentState(g, this) == CardPlayability.NO) {
					throw new IllegalStateException("Can't play this card " + getHand()[i].toString());
				}

				System.out.println("Playing " + getHand()[i].toString());

				Card cp = pullCardFromHand(i);
				if (cp.getType() != CardType.MINION) {
					throw new IllegalStateException("Expected card" + cp.toString() + "to be a minion");
				}
				insertMinionOntoBoard((Minion) cp, iface.whereToPlayCardIndex(g, this, turn));
				spendMana(cp.getCost());

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

	CardPlayability canPlayCard(Game g) {
		CardPlayability rv = CardPlayability.NO;

		loop:
			for (int k = 0; k < getHand().length; k++) {
				switch (getHand()[k].getPlayabilityInCurrentState(g, this)) {
				case WITH_EFFECT:
					if (rv != CardPlayability.WITH_EFFECT) {
						rv = CardPlayability.WITH_EFFECT;
					}
					break loop;
				case YES:
					if (rv == CardPlayability.NO) {
						rv = CardPlayability.YES;
					}
					break;
				case NO:
					break;
				default:
					break;
				}
			}

		return rv;
	}

	CardPlayability canUseHeroPower(Game g) {
		if (!hasUsedHeroPower() && (getHeroPower().getCost() <= getAvaliableMana())) {
			return CardPlayability.YES;
		} else {
			return CardPlayability.NO;
		}
	}
	
	CardPlayability canDoMinionCombat(Game g) {
		for (int k = 0; k < getBoard().length; k++) {
			if (getBoard()[k].canAttack()) {
				return CardPlayability.YES;
			}
		}
		return CardPlayability.NO;
	}
	
	CardPlayability canDoHeroCombat(Game g) {
		return CardPlayability.NO;
	}
}
