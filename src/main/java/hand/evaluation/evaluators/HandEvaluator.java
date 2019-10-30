package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;

public interface HandEvaluator {
    void setNextHandEvaluator(HandEvaluator handEvaluator);
    HandStrength evaluate(List<Card> hand);
}
