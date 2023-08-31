/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

public class Card {
	
	/**
	 * @param args
	 */
	
	private static int suit;
	private static int rank;
	
	public Card() {
		
		this(1, 1);
		
	}
	
	public Card(int r, int s) {
		
		setRank(r);
		setSuit(s);
	
	}
	
	private void setRank(int r) {
		
		if (r > 0 && r < 14) {
			Card.rank = r;
		} else {
			throw new RuntimeException("Such rank is not supported");
		}
		
	}
	
	private static void setSuit(int s) {
		
		if (s > 0 && s < 4) {
			Card.suit = s;
		} else {
			throw new RuntimeException("Such suit is not supported");
		}
		
	}
	
	public String getRank() {
		
		if (Card.rank != 1 | Card.rank != 11 | Card.rank != 12 | Card.rank != 13) {
			
			return String.valueOf(Card.rank);
			
		} else {
			
			switch(Card.rank) {
			
				case 1:
					return ACE;
				case 11:
					return JACK;
				case 12:
					return QUEEN;
				case 13:
					return KING;
				default:
					throw new RuntimeException("Such number is not related to a given Card");
					
			}
			
		}
		
	}
	
	public String getString() {
		
		return getRank() + " of " + getSuit();
		
	}
	
	public String getSuit() {
		
		switch(Card.suit) {
		
			case 1:
				return CLUBS;
			case 2:
				return DIAMONDS;
			case 3:
				return SPADES;
			case 4:
				return HEARTS;
			default:
				throw new RuntimeException("Such number is not related to a given Card");
			
		}
		
	}
	
	private static final String ACE = "Ace";
	private static final String JACK = "Jack";
	private static final String QUEEN = "Queen";
	private static final String KING = "King";
	
	private static final String CLUBS = "Clubs";
	private static final String DIAMONDS = "Diamonds";
	private static final String SPADES = "Spades";
	private static final String HEARTS = "Hearts";
	
}
