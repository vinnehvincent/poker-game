package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;
import model.Rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Straight implements HandEvaluator {
    private HandEvaluator next;
    @Override
    public void setNextHandEvaluator(HandEvaluator handEvaluator) {
        this.next = handEvaluator;
    }

    @Override
    public HandStrength evaluate(List<Card> hand) {
        return hasStraight(hand) ? HandStrength.STRAIGHT : next.evaluate(hand);
    }

    public static boolean hasStraight(final List<Card> hand) {
        List<Integer> lowAceStraight = hand.stream()
                                .map(Card::getRank)
                                .map(Rank::value)
                                .collect(Collectors.toList());
        lowAceStraight.sort(Comparator.naturalOrder());
        if(lowAceStraight.contains(1)){
            List<Integer> highAceStraight = hand.stream()
                    .map(Card::getRank)
                    .map(Rank::value)
                    .collect(Collectors.toList());
            highAceStraight.remove(highAceStraight.indexOf(1));
            highAceStraight.add(14);
            highAceStraight.sort(Comparator.naturalOrder());
            return compareToStraight(lowAceStraight) || compareToStraight(highAceStraight);
        }


        return compareToStraight(lowAceStraight);
    }

    private static boolean compareToStraight(final List<Integer> ranks) {
        List<Integer> straightList = new ArrayList<>();
        for(int i = ranks.get(0); i < ranks.get(0) + ranks.size(); i++ ){
            straightList.add(i);
        }
        return ranks.equals(straightList);
    }

    private static boolean compareAdjacent(List<Card> sortedHand) {
        for (int i = 1; i < 5; i++) {
            int smallerCardValue = sortedHand.get(i - 1).getRank().value();
            int largerCardValue = sortedHand.get(i).getRank().value();

            if (largerCardValue - smallerCardValue != 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Card> sortHand(final List<Card> hand) {
        return hand.stream().sorted(Card.byRank).collect(Collectors.toList());
    }
}
