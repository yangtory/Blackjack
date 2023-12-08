package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.tory.blackjack.model.CardDto;

public class CardService {
	// 선언
	private CardDto cardDto = null;
	private List<CardDto> deck = null;

	// 초기화
	public CardService() {
		cardDto = new CardDto();
	}

	public void blackJack() {
		startGame();
	}

	public void startGame() {
		makeDeck();
	}

	// 카드 만들기
	// deck 초기화, 매개변수로 dto 변수에 할당할수 있게 method 만들기 
	// deck 리스트에 넣기 
	public void card(String value, String type) {
		deck = new ArrayList<CardDto>();
		cardDto.type = type; 
		cardDto.value = value;
		deck.add(cardDto);
		System.out.println(deck);
	}// end card
	
	public void makeDeck() {
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };
		String[] types = { "♠", "♥", "♣", "◆" };

		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				card(values[j], types[i]);
			}
		}
	}// end makeDeck
}
