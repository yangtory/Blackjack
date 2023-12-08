package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.tory.blackjack.model.CardDto;

public class CardService {
	//선언 
	private CardDto carddto = null;
	private List<CardDto>card = null;
	
	//초기화 
	public CardService() {
		carddto = new CardDto();
		card = new ArrayList<CardDto>();
	}
	
	// 카드 만들기 
	public void cardDeck() {
		String denomi = "A,2,3,4,5,6,7,8,9,10,K,Q,J";
		String pattern = "♠,♥,♣,◆";
		String[] denomis = denomi.split(",");
		String[] patterns = pattern.split(",");
		
		int value = 0;
		for(int i = 0 ; i < 13 ; i++) {
			for(int j = 0 ; j < 4; j++) {
				System.out.printf("%s%s,",denomis[i],patterns[j]);
				}	
			}
		}//end for
	}
	
	


