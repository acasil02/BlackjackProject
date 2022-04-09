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

	public boolean hitOrStay() {
		return this.getHandValue() < 17 ? true : false;
	}

}
