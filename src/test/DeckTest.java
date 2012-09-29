package test;

import poker.*;

public class DeckTest {
	public static void main(String[] args) {
		// get a deck to run tests on
		Deck deck = new Deck(52);
				
		// test for deck suit encoding
		//for(int i=0; i<deck.getSize(); i++) {
		//	System.out.println(deck.getCardProperty(i, 1));
		//}
		
		// deck size test
		System.out.println(deck.getSize() + " Karten hat das generierte Deck.");

		// test: encoded Deck
		deck.printDeckEncoded();
						
		// test: decoded Deck
		// arguments: {"fr", "de", "en"}, {"poker", "skat"}
		deck.printDeckDecoded("fr", "poker");
	}
}