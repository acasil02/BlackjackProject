package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	public Deck() {
		deck = createDeck();
	}

	private List<Card> createDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}

	public List<Card> getDeck() {
		return this.deck;
	}

}
