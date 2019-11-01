package hand.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hand.evaluation.chains.FiveCardGameEvaluationChain;
import org.junit.Test;

import model.Card;
import model.HandStrength;
import model.Rank;
import model.Suit;

public class FiveCardGameEvaluationChainTest {

	private FiveCardGameEvaluationChain handEvaluator = new FiveCardGameEvaluationChain();
	
	@Test
	public void shouldReturnFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.EIGHT), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.SIX)) ;
		assertEquals(handEvaluator.evaluate(hand), HandStrength.FLUSH);
	}
	@Test
	public void shouldReturnLowStraightHand() {
		List<Card> hand = Arrays.asList(new Card(Suit.HEARTS, Rank.ACE),new Card(Suit.CLUBS, Rank.TWO),new Card(Suit.CLUBS,Rank.THREE)
				,new Card(Suit.DIAMOND, Rank.FOUR), new Card(Suit.SPADES,Rank.FIVE));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.STRAIGHT);
	}
	@Test
	public void shouldReturnHighAceStraightHand(){
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS.HEARTS,Rank.ACE),new Card(Suit.SPADES,Rank.TEN),
				new Card(Suit.HEARTS,Rank.JACK), new Card(Suit.DIAMOND,Rank.QUEEN), new Card(Suit.HEARTS,Rank.KING));
		assertEquals(handEvaluator.evaluate(hand),HandStrength.STRAIGHT);
	}
	@Test
	public void shouldReturnStraightFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.TWO), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.STRAIGHT_FLUSH);
	}
	@Test
	public void shouldReturnFourOfAKind() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.ACE), new Card(Suit.DIAMOND,Rank.ACE),new Card(Suit.HEARTS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.FOUR_OF_A_KIND);
	}
	@Test
	public void shouldReturnHighCard() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.SEVEN), 
				new Card(Suit.SPADES,Rank.THREE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.HIGH_CARD);
	}
	@Test
	public void shouldReturnThreeOfAKind() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.ACE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.THREE_OF_A_KIND);
	}
	@Test
	public void shouldReturnOnePair() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.NINE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.ONE_PAIR);
	}
	@Test
	public void shouldReturnTwoPair() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.NINE), new Card(Suit.DIAMOND,Rank.NINE),new Card(Suit.HEARTS,Rank.FOUR));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.TWO_PAIR);
	
	}
	@Test
	public void shouldReturnFullHouse() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.DIAMOND, Rank.TWO), new Card(Suit.CLUBS, Rank.TWO),
				new Card(Suit.DIAMOND, Rank.FIVE), new Card(Suit.HEARTS, Rank.FIVE));
		assertEquals(handEvaluator.evaluate(hand), HandStrength.FULL_HOUSE);
	}
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForEmptyHand() {
		handEvaluator.evaluate(new ArrayList<Card>());
	}
	
}
