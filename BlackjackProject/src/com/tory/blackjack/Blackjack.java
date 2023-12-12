package com.tory.blackjack;

import com.tory.blackjack.service.MainService;

public class Blackjack {
	public static void main(String[] args) {
		MainService mainService = new MainService();
		mainService.startGame();
	}

}
