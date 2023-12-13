package com.tory.blackjack.service;

import com.tory.blackjack.model.PlayerDto;

public class PlayerService {
	private CardService cardS = null;
	private PlayerDto dto = null;
	private RuleService ruleS = null;

	public PlayerService() {
		cardS = new CardService();
		dto = new PlayerDto();
		ruleS = new RuleService();
	}

	// 처음 게임 카드 2장 얻고 hit 하면 getCard() 실행
	public void firstGetCard() {
		int playerScore = 0;
		int dealerScore = 0;
		cardS.makeDeck();
		dto.dealerHand.add(cardS.deal());
		dto.dealerHand.add(cardS.deal());
		System.out.println("딜러의 카드");
		System.out.printf("[ ?, %s]\n", dto.dealerHand.get(1));
		for(int i = 0 ; i < dto.dealerHand.size() ; i++) {
			int intvalue = Integer.valueOf(dto.dealerHand.get(i));
			dealerScore = intvalue;
		}
		System.out.println(dealerScore);

		dto.playerHand.add(cardS.deal());
		dto.playerHand.add(cardS.deal());
		System.out.println("플레이어의 카드");
		System.out.println(dto.playerHand);

		while (true) {
			if (ruleS.select() == true) {
				this.getCard();
			}
		}
	}

	// 카드 한장 받기
	public void getCard() {
		dto.playerHand.add(cardS.deal());
		System.out.println("플레이어의 카드");
		System.out.println(dto.playerHand);
	}
}

// 카드 그림을 배열에 담기
// 카드 그림 method
//	public void printCard(List<String> name, int index) {
//		System.out.println("┌─────┐");
//		System.out.printf("│ %3s │\n", name.get(index));
//		System.out.println("└─────┘");
//	}
//
//	// 딜러의 숨겨진 카드 그림
//	public void hideCard(List<String> name) {
//		System.out.println("┌─────┐");
//		System.out.printf("│ ??? │\n", name.get(0)); // 무조건 0번 인덱스 가리기
//		System.out.println("└─────┘");
//	}
