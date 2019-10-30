package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKind implements HandEvaluator {
    private HandEvaluator next;
    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return hasThreeOfAKind(hand) ? HandStrength.THREE_OF_A_KIND : next.evaluate(hand);
    }
    public static boolean hasThreeOfAKind(final List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values()
                .stream()
                .filter(value -> value == 3)
                .count() == 1;
    }
}
