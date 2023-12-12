package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.List;

public class PlayerService extends RuleService {
	private CardService cardS = null;
	protected List<String> playerHand = null;
	protected List<String> dealerHand = null;
//	private RuleService ruleS = null;

	public PlayerService() {
		cardS = new CardService();
		playerHand = new ArrayList<String>();
		dealerHand = new ArrayList<String>();
//		ruleS = new RuleService();
	}

	// 처음 게임 카드 2장 얻고 hit,stop 선택
	public void firstGetCard() {
		cardS.makeDeck();
		dealerHand.add(cardS.deal());
		dealerHand.add(cardS.deal());
		System.out.println("딜러의 카드");
		System.out.printf("[ ?, %s]\n", dealerHand.get(1));

		playerHand.add(cardS.deal());
		playerHand.add(cardS.deal());
		System.out.println("플레이어의 카드");
		System.out.println(playerHand);

//		while (true) {
//			select();
//			if (select() == true) {
//				this.getCard();
//			}
//		}
	}

	// 카드 한장 받기
	public void getCard() {
		playerHand.add(cardS.deal());
		System.out.println("플레이어의 카드");
		System.out.println(playerHand);
		System.out.println(playerHand.size());
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
