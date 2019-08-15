package entities;

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
		return String.format("{Suit: %s, Rank: %s}", suit, rank);
	}
	public static final Comparator<Card> byRank = (card,anotherCard) -> card.getRank().compareTo(anotherCard.getRank());
}
