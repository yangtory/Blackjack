package com.tory.blackjack.model;

public class CardDto {
	
//	public String deck;
	public String type;
	public String value;
	public int intvalue;
	public int score;
	
	public CardDto (String type, String value, int intvalue) {
		this.type = type;
		this.value = value;
		this.intvalue += intvalue;
	}
	
	public int score() {
		score = 0;
		
		
		return score;
	}
	
	//카드 이렇게 표시해주세요 
	public String toString() {
		return value + type + ", 점수 :" + intvalue;
	}

}
