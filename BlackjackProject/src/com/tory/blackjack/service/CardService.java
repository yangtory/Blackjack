package com.tory.blackjack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tory.blackjack.model.CardDto;
import com.tory.blackjack.model.PlayerDto;
import com.tory.blackjack.utils.AnsiConsol;
import com.tory.blackjack.utils.Line;

// playersevice 를 나눴으면 좋겟다
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
		types[1] = AnsiConsol.RED("♥");
		types[3] = AnsiConsol.RED("◆");
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

	// 점수 산정 
	// 각 카드의 점수를 정해줌, 매개변수에 card 를 넣고 card 한 장의 점수를 알수있도록함
	public int getCardValue(String card) {
		String value = card.split(" ")[0]; // 카드를 ""로 split 하고 첫번째 요소만 가져옴, value 만 가져오기
		if (value.equals("A")) {
			return 1;
		} else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
			return 10;
		} else {
			return Integer.valueOf(value);
		}
	}

	// 매개변수에 플레이어의 hand 리스트를 넣어서 
	// 그 리스트에 있는 요소들을 card 에 넣고 getCardValue() 매개변수에 그 card 를 넣어
	// 카드 점수 산정을 한다 그리고
	// 각 카드의 value 를 합해 리턴한다
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

	// 카드 1장 받고 덱에서 그 카드 지우기 
	public String getCard() {
		int rndCard = (int) (Math.random() * deck.size());
		String card = deck.remove(rndCard) + "";
		return card;
	}

	// boolean 으로 false 일때 딜러 카드 숨기기
	public void printHand(boolean showDealerHand) {
		System.out.println("[ 딜러의 카드 ] ");
		if (showDealerHand) {
			System.out.println(playerDto.dealerHand);
			System.out.println("점수  " + sumHandValue(playerDto.dealerHand));
		} else { //false 이면 딜러 카드 중 1번 요소만 보여주기
			System.out.printf("[ ? , %s]\n", playerDto.dealerHand.get(1));
		}
		System.out.println("[ 플레이어의 카드 ] ");
		System.out.println(playerDto.playerHand);
		System.out.println("점수  " + sumHandValue(playerDto.playerHand));
		Line.sLine(50);
	}

	// hit, stop 에 따라 게임진행
	public void playerSelect() {
		while (true) {
			int dealerScore = sumHandValue(playerDto.dealerHand);
			int playerScore = sumHandValue(playerDto.playerHand);
			
			System.out.print("Hit 하려면 1, STOP 하려면 0 을 입력하세요 >>  ");
			String str = scan.nextLine();
			int intStr = 0; // 이 변수가 하는 일 : hit 인지 stop 인지를 알려주는 역할  
			try {
				intStr = Integer.valueOf(str);
			} catch (Exception e) {
				System.out.println("*** 정확히 입력해주세요");
				continue;
			}
			if (intStr < 0 || 1 < intStr) {
				System.out.println("*** 1 과 0 만 입력해주세요");
				continue;
			}

			if (intStr == 1) {
				playerDto.playerHand.add(getCard());
				this.printHand(false);
			}
			
			if (sumHandValue(playerDto.dealerHand) < 17) {
				System.out.println("** 딜러가 카드를 가져갑니다");
				playerDto.dealerHand.add(getCard());
			} // 여기에 딜러의 점수가 21 초과일때 ,승리가 없음
			if (sumHandValue(playerDto.playerHand) >= 21) {
				System.out.println("** 플레이어가 21 초과, 패배 ** ");
				break;
			}

			if (intStr == 0) {
				if (dealerScore > 21) {
					System.out.println("** 딜러가 21 초과, 플레이어 승리 **");
					Line.dLine(50);
					break;
				}
				if (dealerScore < playerScore) {
					System.out.println("** 플레이어 승리 **");
					Line.dLine(50);
					break;
				}
				if (dealerScore > playerScore) {
					System.out.println("** 패배, 딜러 승리 **");
					Line.dLine(50);
					break;
				}
				if (dealerScore == playerScore) {
					System.out.println("** 무승부입니다 **");
					break;
				}
			}
		} // end while
		System.out.println("<게임결과>");
		printHand(true);
	}

	// 딜러, 플레이어 리스트 초기화 하기
	public void reset() {
		playerDto.dealerHand.clear();
		playerDto.playerHand.clear();
	}

	// 재시작
	public void restart() {
		System.out.print("*** 다시 하려면 1, 끝내려면 0 을 입력하세요 >> ");
		String str = scan.nextLine();
		while (true) {
			if (str.equals("1")) {
				reset();
				firstGetCard();
				printHand(false);
				playerSelect();
				restart();
			}
			if (str.equals("0")) {
				System.out.println(" 게임 끝! ");
				Line.dLine(50);
			}
			break;
		}
	}
}
