package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.DealerHand;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.PlayersHand;

public class BlackJackApp {
	Scanner input = new Scanner(System.in);
	private DealerHand dealerHand;
	private PlayersHand playersHand;
	private Deck deck;

	public static void main(String[] args) {

		BlackJackApp blackJackApp = new BlackJackApp();
		blackJackApp.run();

	}

	private void run() {
		menuChoice(input);
		input.close();
	}

	private void printMenu() {
		System.out.println("Welcome to BlackJack");
		System.out.println("-----------------");
		System.out.println("|     Menu       |");
		System.out.println("|  1: Play Game  |");
		System.out.println("|  2: Quit       |");
		System.out.println("------------------");
	}

	private boolean menuChoice(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			printMenu();
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				playBlackJack(input);
				break;
			case 2:
				System.out.println("Exiting, Thank you!");
				return false;
			default:
				System.out.println("Please enter a valid option. Enter 1-2");
				break;
			}
		}
		return keepGoing;
	}

	private void playBlackJack(Scanner input) {
		this.playersHand = new PlayersHand();
		this.dealerHand = new DealerHand();
		this.deck = new Deck();
		this.deck.shuffle();
		firstTwoDraw();
		printHandValues("Hidden");

		boolean keepPlaying = true;
		while (keepPlaying) {
			boolean isPlayerStaying = false;
			if (!this.playersHand.isBust() && this.playersHand.getHandValue() != 21) {
				isPlayerStaying = playerHit(input);
				if (isPlayerStaying) {
					dealerHit();
					if (this.playersHand.getHandValue() > this.dealerHand.getHandValue() && !this.dealerHand.isBust()) {
						printHandValues("Unhidden");
						System.out.println("Player wins");
					} else if (this.dealerHand.isBust()) {
						printHandValues("Unhidden");
						System.out.println("Player wins");
					} else if (this.playersHand.getHandValue() == this.dealerHand.getHandValue()) {
						printHandValues("Unhidden");
						System.out.println("Push");
					} else {
						printHandValues("Unhidden");
						System.out.println("Dealer wins");
					}
					break;
				}
				if (!this.playersHand.isBust()) {
					printHandValues("Hidden");
				}

			}
			if (this.playersHand.isBust()) {
				printHandValues("Unhidden");
				System.out.println("Player has bust, Dealer wins!");
				keepPlaying = false;
				break;
			} else if (this.playersHand.isBlackJack()) {
				if (this.dealerHand.isBlackJack()) {
					printHandValues("Unhidden");
					System.out.println("Push");
					break;
				} else {
					printHandValues("Unhidden");
					System.out.println("Player wins, BlackJack!");
					break;
				}
			}
			if (isPlayerStaying) {
				dealerHit();
				if (dealerHand.isBust()) {
					printHandValues("Unhidden");
					System.out.println("Player wins, Dealer bust");
					break;
				}
			}

		}

	}

	private void firstTwoDraw() {
		System.out.println("Giving out two cards");
		for (int i = 0; i < 2; i++) {
			this.playersHand.addCard(deck.dealCard());
			this.dealerHand.addCard(deck.dealCard());
		}
	}

	private boolean playerHit(Scanner input) {
		System.out.println("Do you want to hit or stand? Enter 1 to hit or 2 to stand");
		int decision = input.nextInt();
		if (decision == 1) {
			this.playersHand.addCard(deck.dealCard());
			System.out.println("Player has decided to hit");
			return false;
		} else if (decision == 2) {
			System.out.println("Player had chose to stand");
			return true;
		} else {
			System.out.println("Invalid option enter 1 or 2");
		}
		return false;
	}

	private void dealerHit() {
		while (this.dealerHand.willDealerHit()) {
			this.dealerHand.addCard(deck.dealCard());
		}
	}

	private void hitOrStay() {
		System.out.println("Do you want to hit or stay?");

	}

	private void printHandValues(String showOrHide) {
		if (showOrHide.equals("Hidden")) {
			System.out.println("Dealers hand: ");
			this.dealerHand.printDealerHiddenHand();
		} else {
			System.out.println("Dealers hand value: " + this.dealerHand.getHandValue());
			this.dealerHand.printUnhiddenHand();
		}
		System.out.println("Players hand value: " + this.playersHand.getHandValue());
		this.playersHand.printUnhiddenHand();

	}
}
