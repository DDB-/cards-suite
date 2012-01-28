package blackjack;

import commons.Deck;

public class BlackJackRunner {
	
	public static void main(String [] args){
		while(true) {
			Deck deck = new Deck();
			
			BlackjackHand playerHand = new BlackjackHand();
			BlackjackHand cpuHand = new BlackjackHand();
			
			playerHand.addCard(deck.nextCard());
			playerHand.addCard(deck.nextCard());
			cpuHand.addCard(deck.nextCard());
			cpuHand.addCard(deck.nextCard());
			
			BlackjackPlayer player = new BlackjackPlayer(playerHand);
			BlackjackAI cpu = new BlackjackAI(cpuHand);
			
			player.turn(deck);
			cpu.turn(deck);
			
			for(BlackjackHand bjHand : player.listHands()) {
				if(bjHand.valueOfHand() > 21)
					System.out.println("BUST! You Lose This Hand.");
				else if(bjHand.valueOfHand() > cpu.getHand().valueOfHand())
					System.out.println("Winner! You beat the CPU");
				else if(cpu.getHand().valueOfHand() > 21)
					System.out.println("Winner! CPU BUST!");
				else
					System.out.println("CPU Victory!");
			}
		}
	}
}
