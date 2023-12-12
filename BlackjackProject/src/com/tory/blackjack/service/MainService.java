package com.tory.blackjack.service;

public class MainService {
	
	private CardService cardService = null;
	private PlayerService playerService = null;
	private RuleService ruleService = null;
	
	public MainService() {
		cardService = new CardService();
		playerService = new PlayerService();
		ruleService = new RuleService();
	}
	
	public void startGame() {
		cardService.makeDeck();
		cardService.shuffleDeck();
		playerService.firstGetCard();
		playerService.getCard();
		ruleService.select();
	}
	

}
