package game.play;

import hand.evaluation.chains.FiveCardGameEvaluationChain;
import model.Card;
import model.HandStrength;

import java.util.List;

public class Player {
	
	String playerName;
	List<Card> hand;
	HandStrength strength;

	
	Player(String playerName, List<Card> hand){
		this.playerName = playerName;
		this.hand = hand;
		this.strength = evaluateStrength(hand);
	}

	private HandStrength evaluateStrength(List<Card> hand) {
		FiveCardGameEvaluationChain eval = new FiveCardGameEvaluationChain();
		return eval.evaluate(hand);
	}
}
