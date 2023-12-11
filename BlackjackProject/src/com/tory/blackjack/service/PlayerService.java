package com.tory.blackjack.service;

import com.tory.blackjack.model.PlayerDto;

public class PlayerService{
	private CardService cardS = null;
	private PlayerDto playerDto = null;
	
	public PlayerService() {
		cardS = new CardService();
		playerDto = new PlayerDto();
	}
	
	//처음 게임 카드 2장 얻기 
	public void firstGetCard() {
		cardS.makeDeck();
		playerDto.dealer.add(cardS.deal());
		playerDto.dealer.add(cardS.deal());
		System.out.println("딜러의 카드");
		System.out.println("");
		playerDto.player.add(cardS.deal());
		playerDto.player.add(cardS.deal());
		System.out.println("플레이어의 카드"+ playerDto.player);
	}
	
	public void getCard() {
		cardS.makeDeck();
		playerDto.player.add(cardS.deal());
		System.out.println("플레이어의 카드"+ playerDto.player);
	}
}
