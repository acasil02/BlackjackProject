package com.skilldistillery.blackjack.cards;

public class DealerHand extends Hand implements BlackJackHand {

	public DealerHand() {
		super();
	}

	public void dealerHit() {

	}

	public void dealerStay() {

	}

	@Override
	public boolean isBlackJack() {
		return this.getHandValue() == 21 ? true : false;
	}

	@Override
	public boolean isBust() {
		return this.getHandValue() > 21 ? true : false;
	}

	@Override
	public void hit(Card card) {
		super.addCard(card);

	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub

	}

	public boolean willDealerHit() {
		return this.getHandValue() < 17 ? true : false;
	}

	public void printDealerHiddenHand() {
		int amountOfCards = 1;
		for (Card card : this.getHand()) {
			if (amountOfCards++ == 1) {
				System.out.println("Hidden card + \t");
			} else {
				System.out.println(card.toString() + "\t");
			}
			System.out.println();

		}
	}

}
