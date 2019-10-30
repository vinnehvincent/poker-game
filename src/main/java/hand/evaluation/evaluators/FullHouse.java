package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;

public class FullHouse implements HandEvaluator {
    private  HandEvaluator next;

    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return isFullHouse(hand) ? HandStrength.FULL_HOUSE : next.evaluate(hand);
    }
    private  boolean isFullHouse(List<Card> hand){
        return ThreeOfAKind.hasThreeOfAKind(hand) && OnePair.hasAPair(hand);
    }
}
