package blackjack;

import commons.Deck;

public class BlackjackAI {
	
	BlackjackHand bjHand;
	
	public BlackjackAI(BlackjackHand bjHand) {
		this.bjHand = bjHand;
	}
	
	public BlackjackHand getHand() {
		return this.bjHand;
	}
	
	public void hit(Deck deck, BlackjackHand bjHand) {
		bjHand.addCard(deck.nextCard());
	}
	
	public void displayHand() {
		for(int i = 0; i < bjHand.cardsInHand(); i++){
			if(i == 0)
				System.out.print("X ");
			else
				System.out.print(bjHand.listCards().get(i).toString() + " ");
		}
	}
	
	public void turn(Deck deck) {
		while(bjHand.valueOfHand() <= 16) {
			displayHand();
			hit(deck, bjHand);
		}
	}
}
