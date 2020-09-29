package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import objectstructures.CardHand;

public class CardDeck implements CardContainer, Iterable<Card> {
	
private List<Card>cardDeck;
	
	//Constructor
	public CardDeck(int n) {
		cardDeck = new ArrayList<>();
		char suit = '\0';
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				suit = 'S';
				break;
			case 1:
				suit = 'H';
				break;
			case 2:
				suit = 'D';
				break;
			case 3:
				suit = 'C';
				break;
		}
			for (int j = 0; j < n; j++) {
				cardDeck.add(new Card(suit , j+1));
			}
		}
	}
	
	public int getCardCount() {
		return cardDeck.size();
	}
	
	public Card getCard(int n) {
		return cardDeck.get(n);
	}
	

	public void shufflePerfectly() {
		int n = getCardCount();
		List<Card>topHalf = new ArrayList<>();
		List<Card>bottomHalf = new ArrayList<>();
		topHalf.addAll(cardDeck.subList(0,  n/2));
		bottomHalf.addAll(cardDeck.subList(n/2, n));	
		
		cardDeck.clear();
		int i = 0;
		int top = 0;
		int bottom = 0;
		while (i < n) {
			if (i % 2 == 0) {
				cardDeck.add(topHalf.get(top));
				top++;
			} else {
				cardDeck.add(bottomHalf.get(bottom));
				bottom++;
			}
			i++;
		}	
		
	}
	
	public void deal(CardHand hand, int n) {
		int i = n;
		for (i = 0; i < n; i++) {
			int kort = cardDeck.size() - 1;
			hand.addCard(cardDeck.get(kort));
			cardDeck.remove(kort);
		}
	}
	
	
	public String toString() {
		return "" + cardDeck;
	}
	
	public static void main(String[] args) {

	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

}

