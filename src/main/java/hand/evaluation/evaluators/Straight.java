package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class Straight implements HandEvaluator {
    private HandEvaluator next;
    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return hasStraight(hand) ? HandStrength.STRAIGHT : next.evaluate(hand);
    }

    public static boolean hasStraight(final List<Card> hand) {

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

    private static List<Card> sortHand(final List<Card> hand) {
        return hand.stream().sorted(Card.byRank).collect(Collectors.toList());
    }
}
