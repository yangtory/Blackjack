package com.tory.blackjack;

import com.tory.blackjack.service.CardService;
import com.tory.blackjack.service.PlayerService;

public class Blackjack {
	public static void main(String[] args) {
		CardService cardService = new CardService();
		PlayerService playerService = new PlayerService();
		cardService.makeDeck();
		cardService.shuffleDeck();

		playerService.firstGetCard();
		playerService.getCard();
		

		
		
		
	
		


		
	}

}
