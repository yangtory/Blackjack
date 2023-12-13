package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.tory.blackjack.model.CardDto;
import com.tory.blackjack.model.PlayerDto;

public class CardService {
	private PlayerDto playerDto = null;
	private List<String> deck = null;
	private Scanner scan = null;

	public CardService() {
		playerDto = new PlayerDto();
		deck = new ArrayList<String>();
		scan = new Scanner(System.in);
	}

	// 덱 만들기
	public void deck() {
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };
		String[] types = { "♠", "♥", "♣", "◆" };
		for (String value : values) {
			for (String type : types) {
				deck.add(value + " " + type);
			}
		}
	}

	// 카드 섞기
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	// sumHandValue() 만들기 전 for문에 사용할 String card를 매개변수로 사용
	public int getCardValue(String card) {
		String value = card.split(" ")[0]; // type 떼고 value 만 가져오기
		if (value.equals("A")) {
			return 1;
		} else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
			return 10;
		} else {
			return Integer.valueOf(value);
		}
	}

	// 매개변수에 리스트를 넣어서 확장 for 사용하고 총합을 구함
	public int sumHandValue(List<String> hand) {
		int value = 0;
		for (String card : hand) {
			value += getCardValue(card);
		}
		return value;
	}

	// 처음 2장 받기
	public void firstGetCard() {
		deck();
		playerDto.dealerHand.add(getCard());
		playerDto.dealerHand.add(getCard());
		playerDto.playerHand.add(getCard());
		playerDto.playerHand.add(getCard());
	}

	// 카드 1장 받기
	public String getCard() {
		int rndCard = (int) (Math.random() * deck.size());
		String card = deck.remove(rndCard) + "";
		return card;
	}

	// boolean을 이용해 false 일때 딜러 카드 숨기기
	public void printHand(boolean showDealerHand) {
		System.out.println("< 딜러의 카드 > ");
		if (showDealerHand) {
			System.out.println(playerDto.dealerHand);
			System.out.println(sumHandValue(playerDto.dealerHand));
		} else {
			System.out.printf("[ ? , %s]\n", playerDto.dealerHand.get(1));
		}
		System.out.println("< 플레이어의 카드 > ");
		System.out.println(playerDto.playerHand);
		System.out.println("현재 점수 : " + sumHandValue(playerDto.playerHand));
		System.out.println("-".repeat(50));
	}

	// hit, stop 에 따라 게임진행
	public void playerSelect() {
		while (true) {
			int dealerScore = sumHandValue(playerDto.dealerHand);
			int playerScore = sumHandValue(playerDto.playerHand);
			System.out.print("Hit 하려면 1, STOP 하려면 0 을 입력하세요 >>  ");
			String str = scan.nextLine();
			int intStr = 0;
			try {
				intStr = Integer.valueOf(str);
			} catch (Exception e) {
				System.out.println("*** 정확히 입력해주세요");
				continue;
			}

			if (intStr == 1) {
				playerDto.playerHand.add(getCard());
				this.printHand(false);
			}
			if (sumHandValue(playerDto.dealerHand) < 17) {
				playerDto.dealerHand.add(getCard());
			}
			if (sumHandValue(playerDto.playerHand) >= 21) {
				System.out.println("** 플레이어가 21 초과, 패배 ** ");
				break;
			} else if (intStr == 0) {

				if (dealerScore > 21) {
					System.out.println("** 딜러가 21 초과, 플레이어 승리 **");
					System.out.println("=".repeat(50));
					break;
				} else if (dealerScore < playerScore) {
					System.out.println("** 플레이어 승리 **");
					System.out.println("=".repeat(50));
					break;
				} else if (dealerScore > playerScore) {
					System.out.println("** 패배, 딜러 승리 **");
					System.out.println("=".repeat(50));
					break;
				} else {
					System.out.println("무승부입니다");
					break;
				}
			}
		} // end while
		System.out.println("<게임결과>");
		printHand(true);
	}
}
