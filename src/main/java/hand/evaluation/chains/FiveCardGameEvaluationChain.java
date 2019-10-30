package hand.evaluation.chains;

import hand.evaluation.evaluators.*;
import model.Card;
import model.HandStrength;

import java.util.List;

public class FiveCardGameEvaluationChain extends EvaluationChain {

    public FiveCardGameEvaluationChain() {
        initializeChain();
    }
    @Override
    protected void initializeChain() {
        this.evaluationHead = new StraightFlush();
        FourOfAKind fourOfAKind = new FourOfAKind();
        FullHouse fullHouse = new FullHouse();
        Flush flush = new Flush();
        Straight straight = new Straight();
        ThreeOfAKind threeOfAKind = new ThreeOfAKind();
        TwoPair twoPair = new TwoPair();
        OnePair onePair = new OnePair();

        this.evaluationHead.setNextHandEvaluator(fourOfAKind);
        fourOfAKind.setNextHandEvaluator(fullHouse);
        fullHouse.setNextHandEvaluator(flush);
        flush.setNextHandEvaluator(straight);
        straight.setNextHandEvaluator(threeOfAKind);
        threeOfAKind.setNextHandEvaluator(twoPair);
        twoPair.setNextHandEvaluator(onePair);
        onePair.setNextHandEvaluator(new HighCard());
    }

    @Override
    public HandStrength evaluate(List<Card> hand){
        if(hand.isEmpty())
            throw new IllegalArgumentException("Cannot evaluate an empty hand");
        return evaluationHead.evaluate(hand);
    }
}
