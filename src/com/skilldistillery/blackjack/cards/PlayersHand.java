package com.skilldistillery.blackjack.cards;

public class PlayersHand extends Hand implements BlackJackHand{

	public PlayersHand() {
		super();

	}

	@Override
	public void hit(Card card) {
		super.addCard(card);
	}

	@Override
	public void stay() {

	}

	@Override
	public boolean isBlackJack() {
		return this.getHandValue() == 21 ? true : false;

	}

	@Override
	public boolean isBust() {
		return this.getHandValue() > 21 ? true : false;
	}
}
	
	
