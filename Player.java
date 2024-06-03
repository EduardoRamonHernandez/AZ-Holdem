package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class acts as a player in the game and has some attributes and methods
 * 
 * @author Eduardo Hernandez
 */

public class Player {
	public ArrayList<Card> startHand;
	public PokerHand finalHand;
	double holdings;

	public Player(ArrayList<Card> hand, double startAmnt) {
		startHand = hand;
		holdings = startAmnt;
	}

	public String getStartHand() {
		String result = "";
		for (int i = 0; i < startHand.size(); i++) {
			result += startHand.get(i).toString() + " ";
		}
		return result;
	}

	public PokerHand getFinalHand() {
		return finalHand;
	}

	public double getEarnings() {
		return holdings;
	}

	public void createBestHand(ArrayList<Card> comCards) {
		PokerHand bestHand = null;
		ArrayList<Card> allCards = new ArrayList<>(startHand);
		allCards.addAll(comCards);
		ArrayList<PokerHand> hands = new ArrayList<>();
		ArrayList<ArrayList<Card>> combinations = generateCombinations(allCards);
		for (ArrayList<Card> combination : combinations) {
			PokerHand currentHand = new PokerHand(combination.get(0), combination.get(1), combination.get(2),
					combination.get(3), combination.get(4));
			hands.add(currentHand);
		}
		bestHand = Collections.max(hands);
		finalHand = bestHand;
	}

	private ArrayList<ArrayList<Card>> generateCombinations(ArrayList<Card> cards) {
		ArrayList<ArrayList<Card>> combinations = new ArrayList<>();
		generateCombinationsHelper(cards, 0, new ArrayList<>(), combinations);
		return combinations;
	}

	private void generateCombinationsHelper(ArrayList<Card> cards, int index, ArrayList<Card> current,
			ArrayList<ArrayList<Card>> combinations) {
		if (current.size() == 5) {
			combinations.add(new ArrayList<>(current));
			return;
		}
		for (int i = index; i < cards.size(); i++) {
			current.add(cards.get(i));
			generateCombinationsHelper(cards, i + 1, current, combinations);
			current.remove(current.size() - 1);
		}
	}

	public void updateEarnings(boolean winOrLoss, double amount) {
		if (winOrLoss) {
			holdings += amount;
		} else {
			holdings -= amount;
		}
	}
}
