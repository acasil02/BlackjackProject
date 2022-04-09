package com.skilldistillery.blackjack.cards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DealerTest {

	public static void main(String[] args) {
		
		
		Deck deck = new Deck();
		deck.shuffle();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many cards do you want?");
		try {
			int numCards = sc.nextInt();
			if (numCards > 52 || numCards < 0) {
				System.out.println("Please enter a number 52 or below");
			} else {
				for (int i = 0; i < numCards; i++) {
					System.out.println(deck.dealCard());
				}
			}
		} catch(InputMismatchException e) {
			System.out.println("Please enter a number 52 or below");
		}

	}

}
