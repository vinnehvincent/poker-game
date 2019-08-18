package scoring.rules;

import java.util.List;
import java.util.stream.Collectors;

import entities.Card;
import entities.HandStrength;

public class HandStrengthCalculator {

	public HandStrength determineHandScore(List<Card> hand) {
		
		if (isStraightFlush(hand))
			return HandStrength.STRAIGHT_FLUSH;
		
		if (hasfourOfAKind(hand))
			return HandStrength.FOUR_OF_A_KIND;
		
		else if(isFullHouse(hand))
			return HandStrength.FULL_HOUSE;
		
		else if (isFlush(hand))
			return HandStrength.FLUSH;
		
		else if (hasStraight(hand))
			return HandStrength.STRAIGHT;
		
		else if (hasThreeOfAKind(hand))
			return HandStrength.THREE_OF_A_KIND;
		
		else if (hasTwoPair(hand))
			return HandStrength.TWO_PAIR;
		
		else if (hasAPair(hand))
			return HandStrength.ONE_PAIR;
		
		return HandStrength.HIGH_CARD;
		
	}


	private boolean isFullHouse(final List<Card> hand) {
		return (hasAPair(hand) && hasThreeOfAKind(hand));
	}

	private boolean isFlush(final List<Card> hand) {
		return hand.stream()
				.collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()))
				.containsValue(Long.valueOf(5));
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
		return hand.stream()
				.collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
				.values()
				.stream()
				.filter(value -> value == 4)
				.count() == 1;
	}
	private boolean hasThreeOfAKind(final List<Card> hand) {
		return hand.stream()
				.collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
				.values()
				.stream()
				.filter(value -> value == 3)
				.count() == 1;
	}
	private boolean hasAPair(final List<Card> hand) {
		return hand.stream()
				.collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
				.values()
				.stream()
				.filter(value -> value == 2)
				.count() == 1;
	}
	private boolean hasTwoPair(final List<Card> hand) {
		return hand.stream()
				.collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
				.values()
				.stream()
				.filter(value -> value == 2)
				.count() == 2;
	}

}
