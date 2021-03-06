package game.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Card;
import model.Rank;
import model.Suit;

public class Poker {
	
	public static void main(String [] args) {
		
		System.out.println("Shuffling...Shuffling...Shuffling");
		List<Card> deck = Arrays.asList(
				new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.TWO),new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FOUR),
				new Card(Suit.HEARTS,Rank.FIVE),new Card(Suit.CLUBS,Rank.SIX),new Card(Suit.SPADES,Rank.SEVEN),new Card(Suit.CLUBS,Rank.EIGHT),
				new Card(Suit.CLUBS,Rank.NINE),new Card(Suit.DIAMOND,Rank.TEN),new Card(Suit.CLUBS,Rank.JACK),new Card(Suit.CLUBS,Rank.QUEEN),new Card(Suit.CLUBS,Rank.KING));
		deck = new ArrayList<>(shuffle(deck));
		
		List<Card> hand = deck.subList(0, 5);
		Player player = new Player("Vincent",hand);
		System.out.println(player);
	}

	private static List<Card> shuffle(final List<Card> deck) {
		List<Card> shuffleDeck = new ArrayList<>(deck);
		Collections.shuffle(shuffleDeck);
		return shuffleDeck;
	}
}
