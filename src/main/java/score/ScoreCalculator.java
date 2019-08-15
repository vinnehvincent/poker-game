package score;

import java.util.List;

import entities.Card;
import entities.Score;
import entities.Suit;

public class ScoreCalculator {
	
	public Score determineHandScore(List<Card> hand) {
		if(isFlushHand(hand))
			return Score.FLUSH;
		else if(isStraightHand(hand))
			return Score.STRAIGHT;
		return Score.HIGH_CARD;
	}
	
	private boolean isFlushHand(final List<Card> hand) {
		Suit currentSuit = hand.get(0).getSuit();
		return hand.stream()
					.allMatch(c-> c.getSuit() == currentSuit);
	}

	public boolean isStraightHand(final List<Card> hand) {
		return false;
	}

	private Score isStraightFlushHand(List<Card> hand) {
		return Score.STRAIGHT_FLUSH;
	}

	private Score isfourOfAKindHand(List<Card> hand) {
		return Score.FOUR_OF_A_KIND;
	}

}
