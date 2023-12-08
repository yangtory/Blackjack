package com.tory.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class CardDto {
	
	public String deck;
	public String type;
	public String value;
	
	//service 에서 만든 카드 이렇게 표시해주세요 
	public String toString() {
		return value + type;
	}

}
