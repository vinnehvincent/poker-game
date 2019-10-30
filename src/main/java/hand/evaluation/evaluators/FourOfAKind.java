package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class FourOfAKind implements HandEvaluator {
    private HandEvaluator next;

    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return hasfourOfAKind(hand) ? HandStrength.FOUR_OF_A_KIND : next.evaluate(hand);
    }
    private boolean hasfourOfAKind(final List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values()
                .stream()
                .filter(value -> value == 4)
                .count() == 1;
    }
}
