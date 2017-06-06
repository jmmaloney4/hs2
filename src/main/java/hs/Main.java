// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/.

package hs;

import java.io.IOException;

public class Main {

	public static void main(String... args) throws IOException {

		Deck d1 = new Deck("./mage");
		Deck d2 = new Deck("./mage");

		HumanPlayer pi1 = new HumanPlayer();
		HumanPlayer pi2 = new HumanPlayer();

		Player p1 = new Player(pi1, d1, CardClass.MAGE);
		Player p2 = new Player(pi2, d2, CardClass.MAGE);

		Game game = new Game(p1, p2);
		game.start();
	}

}
