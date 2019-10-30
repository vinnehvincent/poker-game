package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;

public class StraightFlush implements HandEvaluator {

    private HandEvaluator next;

    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return isStraightFlush(hand) ? HandStrength.STRAIGHT_FLUSH : next.evaluate(hand);
    }
    private boolean isStraightFlush(List<Card> hand){
        return Straight.hasStraight(hand) && Flush.isFlush(hand);
    }
}
