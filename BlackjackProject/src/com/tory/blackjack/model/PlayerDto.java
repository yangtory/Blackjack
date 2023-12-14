package com.tory.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerDto {
	public List<String> playerHand = null; 
	public List<String> dealerHand = null;
	
	public PlayerDto() {
		playerHand = new ArrayList<String>();
		dealerHand = new ArrayList<String>();
	}
}
