package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	private CardContainer cardContainer;
	private int cardNumber = 0;
	
	public CardContainerIterator(CardContainer cardContainer) {
		this.cardContainer = cardContainer;
		
	}

	@Override
	public boolean hasNext() {
		return cardNumber != cardContainer.getCardCount();
	}

	@Override
	public Card next() {
		return cardContainer.getCard(cardNumber++);
	}

}
