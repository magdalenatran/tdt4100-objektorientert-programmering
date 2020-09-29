package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand implements CardContainer, Iterable<Card>{

	private List<Card>cardHand;
	
	public CardHand() {
		cardHand = new ArrayList<>();
	}
	
	public int getCardCount() {
		return cardHand.size();
	}
	
	public Card getCard(int n) {
		return cardHand.get(n);
	}
	
	public void addCard(Card card) {
		cardHand.add(card);
	}
	
	public Card play(int n) {
		return cardHand.remove(n);
	}
	
	public String toString() {
		return "" + cardHand;
	}
	
	
	public static void main(String[] args) {
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
}