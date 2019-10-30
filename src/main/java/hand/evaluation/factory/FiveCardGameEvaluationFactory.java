package hand.evaluation.factory;

import hand.evaluation.chains.EvaluationChain;
import hand.evaluation.chains.FiveCardGameEvaluationChain;

public class FiveCardGameEvaluationFactory implements EvaluationChainAbstractFactory {
    @Override
    public EvaluationChain evaluationChain() {
        return new FiveCardGameEvaluationChain();
    }
}
