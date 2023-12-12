package com.tory.blackjack.service;

import java.util.Scanner;

import com.tory.blackjack.model.RuleDto;

public class RuleService{
	private Scanner scan = null;
	private PlayerService playerS = null;
	private CardService cardS = null;

	public RuleService() {
		scan = new Scanner(System.in);
		playerS = new PlayerService();
		cardS = new CardService();
	}

	// stop 입력받기
	
	
	public boolean select() {
		while (true) {
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
				return true;

			} else if (intStr == 0) {
				return false;
				// 점수를 계산하고 게임이 종료되는 메서드 
			}
		} // end while
	}// end select

}
