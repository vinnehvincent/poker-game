package score;

import java.util.List;
import java.util.stream.Collectors;

import entities.Card;
import entities.Score;
import entities.Suit;

public class ScoreCalculator {

	public Score determineHandScore(List<Card> hand) {
		
		if (isStraightFlush(hand))
			return Score.STRAIGHT_FLUSH;
		
		if (hasfourOfAKind(hand))
			return Score.FOUR_OF_A_KIND;
		
		else if (isFlush(hand))
			return Score.FLUSH;
		
		else if (hasStraight(hand))
			return Score.STRAIGHT;
		
		else if (hasThreeOfAKind(hand))
			return Score.THREE_OF_A_KIND;
		
		else if (hasAPair(hand))
			return Score.ONE_PAIR;
		
		return Score.HIGH_CARD;
		
	}

	private boolean isFlush(final List<Card> hand) {
		Suit currentSuit = hand.get(0).getSuit();
		return hand.stream().allMatch(c -> c.getSuit() == currentSuit);
	}

	public boolean hasStraight(final List<Card> hand) {

		List<Card> sortedHand = sortHand(hand);

		for (int i = 1; i < 5; i++) {

			int smallerCardValue = sortedHand.get(i - 1).getRank().value();
			int largerCardValue = sortedHand.get(i).getRank().value();

			if (largerCardValue - smallerCardValue != 1) {
				return false;
			}
		}
		return true;
	}

	private List<Card> sortHand(final List<Card> hand) {
		return hand.stream().sorted(Card.byRank).collect(Collectors.toList());
	}

	private boolean isStraightFlush(final List<Card> hand) {

		return (isFlush(hand) && hasStraight(hand));

	}

	private boolean hasfourOfAKind(final List<Card> hand) {
		
		List<Card> sortedHand = sortHand(hand);
		int firstCardValue = sortedHand.get(0).getRank().value();
		
		return hand.stream().filter(card -> card.getRank().value() == firstCardValue).count() == 4;
	}
	private boolean hasThreeOfAKind(final List<Card> hand) {
		List<Card> sortedHand = sortHand(hand);
		int firstCardRank = sortedHand.get(0).getRank().value();
		return hand.stream().filter(card -> card.getRank().value() == firstCardRank).count() == 3;
	}
	private boolean hasAPair(final List<Card> hand) {
		return false;
	}

}
