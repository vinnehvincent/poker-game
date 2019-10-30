package hand.evaluation.factory;

import hand.evaluation.chains.EvaluationChain;

public class EvaluationFactory {
    public static EvaluationChain getChain(EvaluationChainAbstractFactory evaluationChainAbstractFactory) {
        return evaluationChainAbstractFactory.evaluationChain();
    }
}
