package com.tory.blackjack.model;

public class CardDto {
	
//	public String deck;
	public String type;
	public String value;
	public int intvalue;
	
	public CardDto(String type, String value, int intvalue) {
		this.type = type;
		this.value = value;
		this.intvalue = intvalue;
	}
	
	//카드 이렇게 표시해주세요 
	public String toString() {
		return value + type;
	}

}
