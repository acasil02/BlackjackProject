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

	private  void run() {
		System.out.println("Welcome to BlackJack");
		System.out.println("-----------------");
		System.out.println("|     Menu       |");
		System.out.println("|  1: Play Game  |");
		System.out.println("|  2: Quit       |");
		System.out.println("------------------");
	}

	private boolean menuChoice(Scanner input) {
		boolean keepDisplaying = true;
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
		return keepDisplaying;
	}

	private void playBlackJack(Scanner input) {
		playBlackJack(input);
		
		
	} 
	
	public void draw() {
		this.playersHand.addCard(Card);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
