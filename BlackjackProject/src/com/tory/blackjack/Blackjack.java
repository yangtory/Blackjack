package com.tory.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.tory.blackjack.model.CardDto;
import com.tory.blackjack.service.CardService;
import com.tory.blackjack.service.PlayerService;

public class Blackjack {
	public static void main(String[] args) {
		CardService cardService = new CardService();
		List<CardDto>deck = new ArrayList<>();
		
		cardService.makeDeck();
		cardService.shuffleDeck();
		cardService.getCard();
		cardService.getCard();
		PlayerService p1 = new PlayerService();
		
		
	
		


		
	}

}
