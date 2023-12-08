package com.tory.blackjack;

import com.tory.blackjack.service.CardService;

public class Blackjack {
	public static void main(String[] args) {
		
		CardService cardService = new CardService();
		cardService.cardDeck();
	}

}
