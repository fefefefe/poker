package experimentGame;
import tools.*;

public class TryDeck {
	public static Deck deck = new Deck(52);
	
	/*
	public static Deck buildDeck(int deckSize) {
		Deck deck = new Deck(deckSize);
		return deck;
	}
	*/
	public static void main(String[] args) {
		// game setup
				
		// tests for deck suit encoding
		//for(int i=0; i<deck.getSize(); i++) {
		//	System.out.println(deck.getCardProperty(i, 1));
		//}
		
		// deck size test
		//System.out.println(deck.getSize());
		
		// test: encoded Deck
		deck.printDeckEncoded();
		
		// test: decoded Deck
		// arguments: {"fr", "de", "en"}, {"poker", "skat"}
		deck.printDeckDecoded("fr", "skat");
	}
}
