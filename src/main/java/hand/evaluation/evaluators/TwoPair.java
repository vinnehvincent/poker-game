package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class TwoPair implements HandEvaluator {
    private HandEvaluator next;
    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return hasTwoPair(hand) ? HandStrength.TWO_PAIR : next.evaluate(hand);
    }
    public static boolean hasTwoPair(final List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values()
                .stream()
                .filter(value -> value == 2)
                .count() == 2;
    }
}
