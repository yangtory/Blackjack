package com.tory.blackjack.service;

public class MainService {
	private CardService cardService = null;

	public MainService() {
		cardService = new CardService();
	}

	public void startGame() {
		System.out.println("=".repeat(50));
		System.out.println("╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮\r\n"
				+ "\t\t블랙잭 카드게임\n" 
				+ "╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\r\n"
				+ "/}__/}\r\n"
				+ "( • ▼•)\r\n");
		System.out.println("=".repeat(50));
		cardService.firstGetCard();
		cardService.printHand(false);
		cardService.playerSelect();
		cardService.restart();
	
	}

}
