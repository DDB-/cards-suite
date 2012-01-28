package commons;

public class Card {
	
	public static final String ACE = "A";
	public static final String JACK = "J";
	public static final String QUEEN = "Q";
	public static final String KING = "K";
	
	public static final String CLUBS = "C"; // Suit #1
	public static final String SPADES = "S"; // Suit #2
	public static final String HEARTS = "H"; // SUit #3
	public static final String DIAMONDS = "D"; // Suit #4
	
	String suit;
	String value;
	
	/**
	 * Creates an instance of a playing Card to be used with Deck
	 * @param value Name of the card, as in A, 2, 3....10, J, Q, K
	 * @param suit Suit of the card, C, S, H, D
	 */
	public Card(int value, int suit) {
		// Deal with values
		if(value == 1){
			this.value = ACE;
		}
		else if(value == 11){
			this.value = JACK;
		}
		else if (value == 12){
			this.value = QUEEN;
		}
		else if (value == 13){
			this.value = KING;
		}
		else {
			this.value = String.valueOf(value);
		}
		
		// Deal with suits
		switch(suit){
			case 1: this.suit = CLUBS; break;
			case 2: this.suit = SPADES; break;
			case 3: this.suit = HEARTS; break;
			case 4: this.suit = DIAMONDS; break;
		}
	}
	
	/*** Returns the suit of the card	 */
	public String getSuit(){
		return this.suit;
	}
	
	/*** Returns the value of the card	 */
	public String getValue(){
		return this.value;
	}
	
	/*** Returns the numeric value of the card */
	public int getCardValue(){
		if(value.equals(ACE)){
			return 1;
		}
		else if(value.equals(JACK) || value.equals(QUEEN)
				|| value.equals(KING)){
			return 10;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
	
	@Override
	public String toString(){
		return (value+suit);
	}
	
	@Override
	public int hashCode() {
		StringBuilder sB = new StringBuilder();
			sB.append(value);
			sB.append(suit);
		
		return sB.toString().hashCode();
	}
}
