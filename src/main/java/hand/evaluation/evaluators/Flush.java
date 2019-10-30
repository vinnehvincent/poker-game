package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class Flush implements HandEvaluator {
    private  HandEvaluator next;
    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return isFlush(hand) ? HandStrength.FLUSH : next.evaluate(hand);
    }
    public static boolean isFlush(final List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()))
                .containsValue(Long.valueOf(5));
    }
}
