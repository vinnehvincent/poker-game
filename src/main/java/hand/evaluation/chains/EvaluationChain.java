package hand.evaluation.chains;

import hand.evaluation.evaluators.HandEvaluator;
import model.Card;
import model.HandStrength;

import java.util.List;

public abstract class EvaluationChain {
    protected HandEvaluator evaluationHead;

    protected abstract void initializeChain();

    public abstract HandStrength evaluate(List<Card> hand);
}
