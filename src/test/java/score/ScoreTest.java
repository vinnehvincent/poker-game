package score;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entities.Card;
import entities.Rank;
import entities.Score;
import entities.Suit;

public class ScoreTest {
	private ScoreCalculator scoreCalculator = new ScoreCalculator();
	
	@Test
	public void shouldCalculateFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.EIGHT), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.SIX)) ;
		assertTrue(scoreCalculator.determineHandScore(hand) == Score.FLUSH);
	}
	@Test
	public void shouldcalculateStraightHand() {
		List<Card> hand = Arrays.asList(new Card(Suit.HEARTS, Rank.ACE),new Card(Suit.CLUBS, Rank.TWO),new Card(Suit.CLUBS,Rank.THREE)
				,new Card(Suit.DIAMOND, Rank.FOUR), new Card(Suit.SPADES,Rank.FIVE));
		assertTrue(scoreCalculator.determineHandScore(hand).equals(Score.STRAIGHT));
	}
	@Test
	public void shouldCalculateStraightFlush() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.CLUBS,Rank.TWO), 
				new Card(Suit.CLUBS,Rank.THREE), new Card(Suit.CLUBS,Rank.FIVE),new Card(Suit.CLUBS,Rank.FOUR));
		assertTrue(scoreCalculator.determineHandScore(hand).equals(Score.STRAIGHT_FLUSH));
	}
	@Test
	public void shouldCalculateFourOfAKind() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.ACE), 
				new Card(Suit.SPADES,Rank.ACE), new Card(Suit.DIAMOND,Rank.ACE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(scoreCalculator.determineHandScore(hand).equals(Score.FOUR_OF_A_KIND));
	}
	@Test
	public void shouldReturnHighCardScore() {
		List<Card> hand = Arrays.asList(new Card(Suit.CLUBS,Rank.ACE),new Card(Suit.HEARTS,Rank.SEVEN), 
				new Card(Suit.SPADES,Rank.THREE), new Card(Suit.DIAMOND,Rank.FIVE),new Card(Suit.HEARTS,Rank.FOUR));
		assertTrue(scoreCalculator.determineHandScore(hand).equals(Score.HIGH_CARD));
	}
}
