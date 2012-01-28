package commons;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	public static final int CARDS_IN_DECK = 52;
	
	private ArrayList<Card> cards;
	private int cardAt;
	
	public Deck(){
		cards = new ArrayList<Card>();
		cardAt = 0;
		generateDeck();
		shuffleDeck();
	}
	
	public void generateDeck() {
		for(int i = 1; i <= 13; i++){
			for(int j = 1; j <= 4; j++){
				cards.add(new Card(i,j));
			}
		}
	}
	
	public void shuffleDeck() {
		cardAt = 0;
		Random generator = new Random();
		for(int i = 0; i < 10000; i++){
			int index1, index2;
			index1 = generator.nextInt(CARDS_IN_DECK - 1) + 1;
			index2 = generator.nextInt(CARDS_IN_DECK - 1) + 1;
			Card c1 = cards.get(index1);
			Card c2 = cards.get(index2);
			
			cards.set(index2, c1);
			cards.set(index1, c2);
		}
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public Card nextCard() {
		return cards.get(cardAt++);
	}
}
