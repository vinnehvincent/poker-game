package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;

public interface HandEvaluator {
    public void setNextHandEvaluator(HandEvaluator handEvaluator);
    public HandStrength evaluate(List<Card> hand);
}
