package score;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entities.Card;
import entities.HandStrength;
import entities.Rank;
import entities.Suit;

public class HandStrengthEvaluatorTest {
	private HandStrengthEvaluator handEvaluator = new HandStrengthEvaluator();
	
	@Test
	public void shouldReturnFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.EIGHT), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.SIX)) ;
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.FLUSH));
	}
	@Test
	public void shouldReturnStraightHand() {
		List<Card> hand = Arrays.asList(new Card(Suit.HEARTS, Rank.ACE),new Card(Suit.CLUBS, Rank.TWO),new Card(Suit.CLUBS,Rank.THREE)
				,new Card(Suit.DIAMOND, Rank.FOUR), new Card(Suit.SPADES,Rank.FIVE));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.STRAIGHT));
	}
	@Test
	public void shouldReturnStraightFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.TWO), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.STRAIGHT_FLUSH));
	}
	@Test
	public void shouldReturnFourOfAKind() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.ACE), new Card(Suit.DIAMOND,Rank.ACE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.FOUR_OF_A_KIND));
	}
	@Test
	public void shouldReturnHighCard() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.SEVEN), 
				new Card(Suit.SPADES,Rank.THREE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.HIGH_CARD));
	}
	@Test
	public void shouldReturnThreeOfAKind() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.ACE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.THREE_OF_A_KIND));
	}
	@Test
	public void shouldReturnOnePair() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.NINE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.ONE_PAIR));
	}
	@Test
	public void shouldReturnTwoPair() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.NINE), new Card(Suit.DIAMOND,Rank.NINE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.TWO_PAIR));
	
	}
	@Test
	public void shouldReturnFullHouse() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.DIAMOND, Rank.TWO), new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMOND, Rank.FIVE), new Card(Suit.HEARTS, Rank.FIVE));
		assertTrue(handEvaluator.evaluateHand(hand).equals(HandStrength.FULL_HOUSE));
	}
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForEmptyHand() {
		handEvaluator.evaluateHand(new ArrayList<Card>());
	}
	
}
