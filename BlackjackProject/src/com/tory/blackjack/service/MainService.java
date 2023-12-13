package com.tory.blackjack.service;

public class MainService {
	private CardService cardService = null;

	public MainService() {
		cardService = new CardService();
	}

	public void startGame() {
		System.out.println("=".repeat(50));
		System.out.println(" 블랙잭 카드게임 ");
		System.out.println("=".repeat(50));
		cardService.firstGetCard();
		cardService.printHand(false);
		cardService.playerSelect();
	
	}

}
