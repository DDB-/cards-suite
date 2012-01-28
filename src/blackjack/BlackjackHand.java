package blackjack;

import java.util.List;

import commons.Card;
import commons.Hand;

public class BlackjackHand extends Hand {
	
	public static final int BUST_VALUE = 21;
	
	
	public BlackjackHand() {
		super();
	}
	
	public BlackjackHand(List<Card> cards) {
		super(cards);
	}
	
	@Override
	public int valueOfHand() {
		int score = 0;
		boolean tryAgain = false; // In case Ace is given 11 and goes bust later
		for (Card c : cardsInHand){
			if(c.getValue() == Card.ACE){
				if((BUST_VALUE - score) < 10 || tryAgain){
					score += 1;
				}
				else {
					score += 11;
					tryAgain = true;
				}
			}
			else {
				score += c.getCardValue();
			}
		}
		return score;
	}
	
	@Override
	public String toString() {
		StringBuilder sB = new StringBuilder();
		for(Card c : cardsInHand) {
			sB.append(c.toString() + " ");
		}
		return sB.toString();
	}

}
