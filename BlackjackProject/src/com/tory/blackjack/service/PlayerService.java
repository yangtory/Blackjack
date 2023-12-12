package com.tory.blackjack.service;

import java.util.List;

import com.tory.blackjack.model.PlayerDto;

public class PlayerService {
	private CardService cardS = null;
	private PlayerDto playerDto = null;

	public PlayerService() {
		cardS = new CardService();
		playerDto = new PlayerDto();
	}

	// 처음 게임 카드 2장 얻기
	public void firstGetCard() {
		cardS.makeDeck();
		playerDto.dealer.add(cardS.deal());
		playerDto.dealer.add(cardS.deal());
		System.out.println("딜러의 카드");
		System.out.print("");
		this.hideCard(playerDto.dealer);
		this.printCard(playerDto.dealer, 0);

		playerDto.player.add(cardS.deal());
		playerDto.player.add(cardS.deal());
		System.out.println("플레이어의 카드");
		this.printCard(playerDto.player, 0);
		this.printCard(playerDto.player, 1);
	}

	public void getCard() {
		cardS.makeDeck();
		playerDto.player.add(cardS.deal());
		System.out.println("플레이어의 카드" + playerDto.player);
		for (int i = 0; i < playerDto.player.size(); i++) {
			this.printCard(playerDto.player, i);
			
//			this.printCard(playerDto.player, playerDto.player.size() - 1);
		}
	}

	// 카드 그림을 배열에 담기
	// 카드 그림 method
	public void printCard(List<String> name, int index) {
		System.out.println("┌─────┐");
		System.out.printf("│ %3s │\n", name.get(index));
		System.out.println("└─────┘");
	}

	// 딜러의 숨겨진 카드 그림
	public void hideCard(List<String> name) {
		System.out.println("┌─────┐");
		System.out.printf("│ ??? │\n", name.get(0)); // 무조건 0번 인덱스 가리기
		System.out.println("└─────┘");
	}
}
