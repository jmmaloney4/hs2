// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

public interface PlayerInterface {
	
	void StartingGame(Game g);

	void StartingMulligan(Game g, Player p, Card[] hand);
	boolean KeepCard(Game g, Player p, Card c);
	void StartingHand(Game g, Player p, Card[] hand);

	void StartingTurn(Game g, Player p, int turn, Card c);
	PlayerAction NextAction(Game g, Player p, int turn);

	int CardToPlayHandIndex(Game g, Player p, int turn);
	int WhereToPlayCardIndex(Game g, Player p, int turn);

}
