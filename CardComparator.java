package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	boolean ace;
	char triumph;
	
	public CardComparator(boolean ace, char triumph) {
		this.ace = ace;
		this.triumph = triumph;
	}
	private int aceComparison(Card card1, Card card2) {
		if(card1.getSuit() == card2.getSuit()){
			if(card1.getFace() == 1) {
				return 1;
			}
			return -1;
		}
		return card1.compareTo(card2);
	}
	@Override
	public int compare(Card card1, Card card2) {
		if (!ace && triumph == ' ') {
			return card1.compareTo(card2);
		} else if (ace && triumph == ' ') {
			return aceComparison(card1, card2);
		}else if (triumph != ' ') {
			if(card1.getSuit() == triumph && card2.getSuit() != triumph) {
				return 1;
			}else if(card1.getSuit() != triumph && card2.getSuit() == triumph) {
				return -1;
			}
			if(ace) {
				return aceComparison(card1, card2);
			}
		}
		return card1.compareTo(card2);
	}
}
