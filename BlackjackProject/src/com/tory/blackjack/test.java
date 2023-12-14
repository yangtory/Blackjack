package com.tory.blackjack;

import java.util.ArrayList;
import java.util.List;

public class test {
	    public static String[] cardPrint(String value, String type) {
	        String[] card = {
	            String.format("┌──────┐"),
	            String.format("│  %1s   │", type),
	            String.format("│      │"),
	            String.format("│      │"),
	            String.format("│  %2s  │", value),
	            String.format("└──────┘")
	        };

	        return card;
	    }

	    public static void print(String[] cards) {
	        for (int i = 0; i < cards.length; i++) {
	            System.out.print(cards[i] + " ");
	        }
	        System.out.println();
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

	        for (String[] card : deckList) {
	            print(card);
	        }
	    }
	}


