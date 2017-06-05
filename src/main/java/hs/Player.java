// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import java.util.Arrays;

import hs.hero.Fireblast;
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
	
	boolean usedHeroPower;
	
	boolean hasUsedHeroPower() {
		return usedHeroPower;
	}
	
	boolean canUseHeroPower() {
		if (!hasUsedHeroPower() && (getHeroPower().getCost() <= getAvaliableMana())) {
			return true;
		} else {
			return false;
		}
	}
	
	CardClass heroClass;
	Card heroPower;
	
	PlayerInterface iface;

	Card[] hand;
	Card[] board;
	
	Card[] getHand() {
		return hand;
	}
	
	Card[] getBoard() {
		return board;
	}
	
	CardClass getHeroClass() {
		return heroClass;
	}
	
	Card getHeroPower() {
		return heroPower;
	}

	
	
	public Player(PlayerInterface iface, Deck d, CardClass cls) {
		this.iface = iface;
		this.deck = d;
		
		this.heroClass = cls;
		this.heroPower = new Fireblast();
		
		this.board = new Card[0];
	}

	public void StartGame(Game g, boolean p1) {
		iface.StartingGame(g);

		manaCrystals = 0;
		lockedMana = 0;
		overloadedMana = 0;
		mana = 0;
		
		usedHeroPower = false;

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
				if (getHand()[i].getPlayabilityInCurrentState(g, this) == CardPlayability.NO) {
					throw new IllegalStateException("Can't play this card " + getHand()[i].toString());
				}
				
				System.out.println("Playing " + getHand()[i].toString());
				
				Card cp = hand[i];
				spendMana(cp.getCost());
				
				Card[] nh = new Card[hand.length - 1];
				for (int k = 0; k < i; k++) {
					nh[k] = hand[k];
				}
				for (int k = i; k < nh.length; k++) {
					nh[k] = hand[k + 1];
				}
				
				hand = nh;
				
				int pi = iface.WhereToPlayCardIndex(g, this, turn);
				
				Card[] nb = new Card[getBoard().length + 1]; 
				for (int k = 0; k < pi; k++) {
					nb[k] = board[k];
				}
				nb[pi] = cp;
				for (int k = pi + 1; k < nb.length; k++) {
					nb[k] = getBoard()[k - 1];
				}
				
				board = nb;
				
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
