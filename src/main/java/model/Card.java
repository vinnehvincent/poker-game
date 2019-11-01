package model;

import java.util.Comparator;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank value) {
		this.suit = suit;
		this.rank = value;
	}
	public Suit getSuit() {
		return suit;
	}
	public Rank getRank() {
		return rank;
	}
	@Override
	public String toString() {
		return String.format("%s%s", rank.getName(), suit.code());
	}
	public static final Comparator<Card> byRank = Comparator.comparing(Card::getRank);
}
