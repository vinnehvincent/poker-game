package hand.evaluation;

import hand.evaluation.evaluators.Straight;
import model.Card;
import model.HandStrength;
import model.Rank;
import model.Suit;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest {
    @Test
    public void shouldReturnStraightForHighAce(){
        Straight straight = new Straight();
        straight.setNextHandEvaluator(null);
        List<Card> hand = Arrays.asList(new Card(Suit.CLUBS.HEARTS,Rank.ACE),new Card(Suit.SPADES,Rank.TEN),
                new Card(Suit.HEARTS,Rank.JACK), new Card(Suit.DIAMOND,Rank.QUEEN), new Card(Suit.HEARTS,Rank.KING));
        assertEquals(straight.evaluate(hand), HandStrength.STRAIGHT);

    }
}
