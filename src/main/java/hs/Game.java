// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

public class Game {
	
	Player p1;
	Player p2;
	
	int turn;
	
	Game(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void Start() {
		
		p1.StartGame(this, true);
		p2.StartGame(this, false);
		
		String[] op = {"Hello, World0", "Hello, World1", "Hello, World2"};
		CardPlayability[] p = {CardPlayability.NO, CardPlayability.YES, CardPlayability.WITH_EFFECT};
		
		HumanPlayer.getOptionChoice(op, p);
		
		turn = 0;
		
		while (true) {
			p1.TakeTurn(this, turn);
			turn++;
			p2.TakeTurn(this, turn);
			turn++;
		}
	}
	
}
