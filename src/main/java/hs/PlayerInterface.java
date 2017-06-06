// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

public interface PlayerInterface {

	void startingGame(Game g);

	void startingMulligan(Game g, Player p, Card[] hand);

	boolean keepCard(Game g, Player p, Card c);

	void startingHand(Game g, Player p, Card[] hand);

	void startingTurn(Game g, Player p, int turn, Card c);

	PlayerAction nextAction(Game g, Player p, int turn);

	int cardToPlayHandIndex(Game g, Player p, int turn);

	int whereToPlayCardIndex(Game g, Player p, int turn);

}
