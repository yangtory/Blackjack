package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.tory.blackjack.model.CardDto;

public class PlayerService {
	private List<CardService>card = null;
	
	public PlayerService() {
		card = new ArrayList<CardService>();
	}
	
	//카드 1장 얻기 
	public void getCard(CardService deck) {
		this.card.add(deck);
		// CardDto의 카드를 이 클래스의 카드에 넣기 
	}
	
	public void printCard() {
		System.out.println(card);
	}

}
