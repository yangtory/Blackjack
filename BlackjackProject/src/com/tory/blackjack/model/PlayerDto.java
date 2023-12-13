package com.tory.blackjack.model;

import java.util.ArrayList;
import java.util.List;

import com.tory.blackjack.service.CardService;

public class PlayerDto {
	public List<String> playerHand = null; 
	public List<String> dealerHand = null;
	public CardService card = null;
	public CardDto cardDto = null;
	public int usersum;
	
	public PlayerDto() {
		playerHand = new ArrayList<String>();
		dealerHand = new ArrayList<String>();
	}
	
}
