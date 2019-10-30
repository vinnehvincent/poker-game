package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;

import java.util.List;

public class HighCard implements HandEvaluator {
    private HandEvaluator nextHandEvaluator;

    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.nextHandEvaluator = null;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
      return HandStrength.HIGH_CARD;
    }
}
