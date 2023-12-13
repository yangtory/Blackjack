package com.tory.blackjack.service;

import java.util.List;

import com.tory.blackjack.model.CardDto;
import com.tory.blackjack.model.PlayerDto;

public class PlayerService {
	private CardDto cardDto = null;
	private CardService cardS = null;
	private PlayerDto dto = null;
	private RuleService ruleS = null;

	public PlayerService() {
		cardDto = new CardDto();
		cardS = new CardService();
		dto = new PlayerDto();
		ruleS = new RuleService();
	}

	// 처음 게임 카드 2장 얻고 hit 하면 getCard() 실행
	public void firstGetCard() {

		cardS.makeDeck();
		dto.dealerHand.add(cardS.deal());
		dto.dealerHand.add(cardS.deal());
		System.out.println("딜러의 카드");
		System.out.println(dto.dealerHand); 
//		System.out.printf("[ ?, %s]\n", dto.dealerHand.get(1));
		System.out.println("점수 합 : " + cardS.dealerValue());
		

		dto.playerHand.add(cardS.deal());
		dto.playerHand.add(cardS.deal());
		System.out.println("플레이어의 카드");
		System.out.println(dto.playerHand);
//		System.out.println("점수 합 : " + cardS.sumValue());

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
	} //end getCard
	
//	public int sumScore() {
//		int sumValue = 0;
//			int cardValue = cardS.getValue();
//			sumValue += cardValue;
//		return sumValue;
//	} //end getCard
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
