package hand.evaluation;

import hand.evaluation.chains.EvaluationChain;
import hand.evaluation.chains.FiveCardGameEvaluationChain;
import hand.evaluation.factory.EvaluationFactory;
import hand.evaluation.factory.FiveCardGameEvaluationFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluationChainFactoryTest {

    @Test
    public void shouldReturnRuleChainForFiveCArdGame(){
        EvaluationChain evaluationChain = EvaluationFactory.getChain(new FiveCardGameEvaluationFactory());
        assertEquals(evaluationChain instanceof FiveCardGameEvaluationChain,true);
    }
}
