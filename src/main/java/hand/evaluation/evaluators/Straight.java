package hand.evaluation.evaluators;

import model.Card;
import model.HandStrength;
import model.Rank;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> ranks = extractRanks(hand);
        ranks.sort(Comparator.naturalOrder());

        if(ranks.contains(1)){
            List<Integer> highAceRanks = changeLowAceToHighAceValue(ranks);
            return isStraight(ranks) || isStraight(highAceRanks);
        }

        return isStraight(ranks);
    }

    private static List<Integer> extractRanks(final List<Card> hand) {
        return hand.stream()
                .map(Card::getRank)
                .map(Rank::value)
                .collect(Collectors.toList());
    }

    private static List<Integer> changeLowAceToHighAceValue(final List<Integer> ranks) {
        List<Integer> highAceRanks = new ArrayList<>(ranks);
        highAceRanks.remove(highAceRanks.indexOf(1));
        highAceRanks.add(14);
        highAceRanks.sort(Comparator.naturalOrder());
        return highAceRanks;
    }

    private static boolean isStraight(final List<Integer> ranks) {
        List<Integer> straight = new ArrayList<>();
        for(int i = ranks.get(0); i < ranks.get(0) + ranks.size(); i++ ){
            straight.add(i);
        }
        return ranks.equals(straight);
    }

}
