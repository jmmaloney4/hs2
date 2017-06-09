package event;

import hs.Game;

public class GameStartEvent extends Event {

	Game g;

	GameStartEvent(Game g) {
		this.g = g;
	}

	Game getGame() {
		return g;
	}

}
