// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import java.util.Arrays;

import event.Event;
import event.Listener;

public class Game {

	Player p1;
	Player p2;

	int turn;

	Game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	void start() {

		p1.startGame(this, true);
		p2.startGame(this, false);

		turn = 0;

		while (true) {
			p1.takeTurn(this, turn);
			turn++;
			p2.takeTurn(this, turn);
			turn++;
		}
	}
	
	Player getPlayer1() {
		return p1;
	}

	Player getPlayer2() {
		return p2;
	}
	
}
