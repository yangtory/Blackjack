package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tory.blackjack.model.CardDto;
import com.tory.blackjack.model.PlayerDto;

public class CardService {
	// 선언
	private CardDto cardDto = null;
	private List<CardDto> deck = null;
	private PlayerDto playerDto = null;

	// 초기화
	public CardService() {
		deck = new ArrayList<CardDto>();
		playerDto = new PlayerDto();

	}

	// 카드 만들면서 점수 넣어주기
	public void makeDeck() {
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };
		String[] types = { "♠", "♥", "♣", "◆" };

		for (String type : types) {
			for (String value : values) {
				int intValue = 0;
				try {
					intValue = Integer.valueOf(value);
				} catch (Exception e) {
					if (value.equals("A")) {
						intValue = 1;
					} else {
						intValue = 10;
					}

					cardDto = new CardDto();
					cardDto.type = type;
					cardDto.value = value;
					cardDto.intvalue = intValue;
					deck.add(cardDto);
				}
			} // for end
		}
	}// end makeDeck

	// 셔플
	public void shuffleDeck() {
		Collections.shuffle(deck);
//		System.out.println("전체 카드수량 : " + deck.size()); 수량 확인용  
	}

	// 카드 1장을 주면 deck 에서 사라짐
	public String deal() {
		makeDeck();
		int rndCard = (int) (Math.random() * deck.size());
		String card = deck.remove(rndCard) + "";
//		System.out.println("남은 카드수량 : " + deck.size()); 수량 확인용
		return card;
	} // end deal()

}
