package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card>{

	private char cardSuit;
	private int cardFace;
	
	//Constructor
	public Card(char cardSuit, int cardFace) {
		if (!validateCardSuit(cardSuit)) {
			throw new IllegalArgumentException("Not a valid card suit");
		}
		if (!validateCardFace(cardFace)) {
			throw new IllegalArgumentException("Not a valid card face");
		}
		this.cardSuit = cardSuit;
		this.cardFace = cardFace;
	}
	//Validates card suit
	private boolean validateCardSuit(char cardSuit) {
		if (cardSuit == 'S' || cardSuit == 'H' || cardSuit == 'D' || cardSuit == 'C') {
			return true;
		}
		return false;
	}
	//Validates card face
	private boolean validateCardFace(int cardFace) {
		if (cardFace <= 0 || cardFace > 13) {
			return false;
		}
		return true;
	}
	
	public char getSuit() {
		return cardSuit;
	}
	
	public int getFace() {
		return cardFace;
	}
	
	public String toString() {
		return "" + cardSuit + cardFace;
	}
	@Override
	public int compareTo(Card card) {
		if (this.getSuit() == card.getSuit()) {
			if (this.getFace() < card.getFace()) {
				return -1;
			}
		} else if (this.getSuit() == 'C') {
			return -1;
		} else if (this.getSuit() == 'D' && card.getSuit() != 'C') {
			return -1;
		} else if (this.getSuit() == 'H' && (card.getSuit() != 'D' || card.getSuit() != 'C')) {
			return -1;
		}
		return 1;
	}
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card('H',13));
		cards.add(new Card('S', 1));
		cards.add(new Card('C', 3));
		cards.add(new Card('D', 8));
		cards.add(new Card('D', 1));
		Collections.sort(cards);
		System.out.println(cards);
		}
}
