package com.tory.blackjack;

import java.util.ArrayList;
import java.util.List;

public class 실험실 {

	public static String[] cardPrint(String value, String type) {
		String[] cardA = { 
				String.format("┌──────┐ "), 
				String.format("│  %1s   │ ", type), 
				String.format("│      │ "),
				String.format("│      │ "), 
				String.format("│  %2s  │ ", value), 
				String.format("└──────┘ ")
		};
		return cardA;
	}

	public static void main(String[] args) {
		List<String[]> deckList = new ArrayList<String[]>();

		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };
		String[] types = { "♠", "♥", "♣", "◆" };

		for (String value : values) {
			for (String type : types) {
				deckList.add(cardPrint(value, type));
			}
		}

		for (int i = 0; i < deckList.get(0).length; i++) { // 배열로 만든 cardA 의 length = 6
			for (String[] card : deckList) {
				System.out.print(card[i] + " ");
			}
			System.out.println();
		}
	}
}
