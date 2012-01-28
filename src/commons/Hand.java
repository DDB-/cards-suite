package commons;

import java.util.LinkedList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cardsInHand;
	
	public Hand() {
		cardsInHand = new LinkedList<Card>();
	}
	
	public Hand(List<Card> cards) {
		cardsInHand = cards;
	}
	
	public void addCard(int value, int suit){
		Card card = new Card(value, suit);
		cardsInHand.add(card);
	}
	
	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public void removeCard(Card card) {
		cardsInHand.remove(card);
	}
	
	public int cardsInHand() {
		return cardsInHand.size();
	}
	
	public List<Card> listCards() {
		return cardsInHand;
	}
	
	public abstract int valueOfHand();
}
