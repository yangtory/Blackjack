package com.tory.blackjack.model;

import com.tory.blackjack.service.CardService;

public class CardDto extends CardService {

//	public String deck;
	public String type;
	public String value;
	public int intvalue;
	public int sumvalue;

//	public CardDto (String type, String value, int intvalue) {
//		this.type = type;
//		this.value = value;
//		this.intvalue = intvalue;
//	}

	// 카드 이렇게 표시해주세요
	public String toString() {
		return value + type + intvalue;
	}
	
	public int sumValue() {

		return sumvalue;
	}

	

}
