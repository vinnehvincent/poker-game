package game.play;

import hand.evaluation.chains.FiveCardGameEvaluationChain;
import model.Card;
import model.HandStrength;

import java.util.List;
import java.util.stream.Collectors;

public class Player {
	
	String playerName;
	List<Card> hand;
	HandStrength strength;

	
	Player(String playerName, List<Card> hand){
		this.playerName = playerName;
		this.hand = hand;
		this.strength = evaluateStrength(hand);
	}

	public String toString() {
		String handString = hand.stream().map(Object::toString).collect(Collectors.joining(" "));
		return String.format("%s\nYour hand: %s \nYou have: %s",playerName.toUpperCase(), handString, this.strength.toString());
	}

	private HandStrength evaluateStrength(List<Card> hand) {
		FiveCardGameEvaluationChain eval = new FiveCardGameEvaluationChain();
		return eval.evaluate(hand);
	}

}
