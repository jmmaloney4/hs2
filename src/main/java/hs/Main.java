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
        game.Start();
    }

}
