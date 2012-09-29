package poker;

import java.util.HashMap;

/*
 * generates a deck of cards
 */
public class Deck {
	private int[][] deck;

	// Constructor
	// deckSize e.g.: 32(Skat), 52(Poker), 104(Romme)
	public Deck(int deckSize) {
		deck = new int[deckSize][2];
		for(int i = 0; i < deckSize; i++){
			if(deckSize == 104) {
				deck[i][0] = i % (deckSize / 8);
			} else deck[i][0] = i % (deckSize / 4);			
			deck[i][1] = (int) i / (deckSize / 4);
			
		}		
	}
	// card: which number in the deck
	// rankOrSuit: 0 to get the rank, 1 for the suit
	public int getCardProperty(int card, int rankOrSuit) {
		return deck[card][rankOrSuit];
	}
	// nr. of cards in the deck
	public int getSize() {
		return deck.length;
	}
	// prints encoded deck
	public void printDeckEncoded() {
		for(int i = 0; i < this.getSize(); i++){
			System.out.println(deck[i][0] + " " + deck[i][1]);
		}
	}
	// prints decoded deck
	// lang e.g.: "fr" (, "de", "en" not yet)
	// game e.g.: "poker", "skat"
	public void printDeckDecoded(String lang, String game) {
		String[][] f = new String[this.getSize()][2];
				
		if(game == "poker") {
			HashMap<Integer, String> transRankToPoker = new HashMap<Integer, String>();
			transRankToPoker.put(0, "2");
			transRankToPoker.put(1, "3");
			transRankToPoker.put(2, "4");
			transRankToPoker.put(3, "5");
			transRankToPoker.put(4, "6");
			transRankToPoker.put(5, "7");
			transRankToPoker.put(6, "8");
			transRankToPoker.put(7, "9");
			transRankToPoker.put(8, "10");
			transRankToPoker.put(9, "Bube");
			transRankToPoker.put(10, "Dame");
			transRankToPoker.put(11, "Koenig");
			transRankToPoker.put(12, "Ass");
			for(int i = 0; i < this.getSize(); i++){
				f[i][0] = transRankToPoker.get(this.getCardProperty(i, 0));
			}
		}
		if(game == "skat") {
			HashMap<Integer, String> transRankToSkat = new HashMap<Integer, String>();
			transRankToSkat.put(0, "7");
			transRankToSkat.put(1, "8");
			transRankToSkat.put(2, "9");
			transRankToSkat.put(3, "10");
			transRankToSkat.put(4, "Bube");
			transRankToSkat.put(5, "Dame");
			transRankToSkat.put(6, "Koenig");
			transRankToSkat.put(7, "Ass");
			for(int i = 0; i < this.getSize(); i++){
				f[i][0] = transRankToSkat.get(this.getCardProperty(i, 0));
			}
		}
		if(lang == "fr") {
			HashMap<Integer, String> transFranzSuit = new HashMap<Integer, String>();
			transFranzSuit.put(0, "Karo");
			transFranzSuit.put(1, "Herz");
			transFranzSuit.put(2, "Pik");
			transFranzSuit.put(3, "Kreuz");
			
			for(int i = 0; i < this.getSize(); i++){
				f[i][1] = transFranzSuit.get(this.getCardProperty(i, 1));
			}
		}
		if(lang == "de") {
			HashMap<Integer, String> transGermanSuit = new HashMap<Integer, String>();
			transGermanSuit.put(0, "Schellen");
			transGermanSuit.put(1, "Rot");
			transGermanSuit.put(2, "Gr�n");
			transGermanSuit.put(3, "Eichel");
			
			for(int i = 0; i < this.getSize(); i++){
				f[i][1] = transGermanSuit.get(this.getCardProperty(i, 1));
			}
		}
		if(lang == "en") {
			HashMap<Integer, String> transEnSuits = new HashMap<Integer, String>();
			transEnSuits.put(0, "Diamonds");
			transEnSuits.put(1, "Hearts");
			transEnSuits.put(2, "Spades");
			transEnSuits.put(3, "Clubs");
			
			for(int i = 0; i < this.getSize(); i++){
				f[i][1] = transEnSuits.get(this.getCardProperty(i, 1));
			}
		}
		for(int i = 0; i < this.getSize(); i++){
			System.out.println(f[i][0] + " " + f[i][1]);
		}
	}
}
