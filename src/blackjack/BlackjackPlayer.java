package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import commons.Card;
import commons.Deck;

public class BlackjackPlayer {

	ArrayList<BlackjackHand> bjHands;
	
	public BlackjackPlayer(BlackjackHand bjHand) {
		bjHands.add(bjHand);
	}
	
	public ArrayList<BlackjackHand> listHands() {
		return this.bjHands;
	}
	
	private void hit(Deck deck, BlackjackHand bjHand) {
		bjHand.addCard(deck.nextCard());
	}
	
	private boolean canSplit(BlackjackHand bjHand) {
		if(bjHand.cardsInHand()!= 2)
			return false;
		
		if(bjHand.listCards().get(0).getValue() == bjHand.listCards().get(1).getValue())
			return true;
		
		return false;
	}
	
	private void split(BlackjackHand bjHand) {
		List<Card> twoCards = bjHand.listCards();
		
		BlackjackHand n1 = new BlackjackHand(twoCards.subList(0, 0));
		BlackjackHand n2 = new BlackjackHand(twoCards.subList(1, 1));
		
		bjHands.removeAll(bjHands);
		
		bjHands.add(n1);
		bjHands.add(n2);
	}
	
	public void displayHand(BlackjackHand bjHand) {
		if(bjHands.size() == 1) 
			System.out.println("Player Hand");
		else if(bjHand.equals(bjHands.get(0)))
			System.out.println("Player Hand 1");
		else
			System.out.println("Player Hand 2");
		
		for(Card c : bjHand.listCards()) {
			System.out.print(c.toString() + " ");
		}
		System.out.println("");
	}
	
	public void turn(Deck deck) {
		for(BlackjackHand b : bjHands) {
			boolean done = false;
			while(!done){
				displayHand(b);
				if(bjHands.size() == 1 && canSplit(b))
					System.out.println("(H)it, (S)tay or Spli(t)? ");
				else
					System.out.println("(H)it or (S)tay? ");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = null;
				try {
					boolean response = false;
					while(!response) {
						input = br.readLine();
						if(input.compareToIgnoreCase("s") == 0){
							response = true;
							done = true;
						}
						else if(input.compareToIgnoreCase("h") == 0) {
							hit(deck, b);
							response = true;
							if(b.valueOfHand() > 21)
								done = true;
						}
						else if(input.compareToIgnoreCase("t") == 0) {
							split(b);
							response = true;
						}
						else {
							System.out.println("You idiot, choose correctly!");
						}
					}
					
				} catch (IOException e) {
					System.out.println("Error Reading Input Selection. Now Exiting.");
					System.exit(0);
				}
			}
		}
	}
	

}
