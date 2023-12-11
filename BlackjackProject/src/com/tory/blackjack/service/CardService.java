package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tory.blackjack.model.CardDto;

public class CardService {
	// 선언
	protected CardDto cardDto = null;
	protected List<CardDto> deck = null;
	protected List<String> player = null;
	protected List<String> dealer = null;

	// 초기화
	public CardService() {
		deck = new ArrayList<CardDto>();
		player = new ArrayList<String>();
		dealer = new ArrayList<String>();
	}

	// 카드 만들면서 점수 넣어주기
	public void makeDeck() {
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8",
							"9", "10", "K", "Q", "J" };
		String[] types = { "♠", "♥", "♣", "◆" };

		int intValue = 0;
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				try {
					intValue = Integer.valueOf(values[j]);
				} catch (Exception e) {
					if (values[j].equals("A")) {
						intValue = 1;
					} else {
						intValue = 10;
					}
				}
				// 먼저 초기화 해놓고 불러오는게 안돼서 이렇게
				deck.add(new CardDto(types[i], values[j], intValue));
			}
		} // for end
	}// end makeDeck

	// 셔플
	public void shuffleDeck() {
		Collections.shuffle(deck);
//		System.out.println("전체 카드수량 : " + deck.size()); 수량 확인용  
	}

	// 카드 1장을 주면 deck 에서 사라짐
	public String deal() {
		int rndCard = (int) (Math.random() * deck.size());
		String card = deck.remove(rndCard) + "";
//		System.out.println("남은 카드수량 : " + deck.size()); 수량 확인용 
		return card;
	} //end deal()
}
