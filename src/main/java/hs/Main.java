package hs;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
    
        Deck d1 = new Deck("./mage");
        Deck d2 = new Deck("./mage");
        
        HumanPlayer p1 = new HumanPlayer(d1);
        HumanPlayer p2 = new HumanPlayer(d2);
        
        Game game = new Game(p1, p2);
        game.Start();
    }

}
