package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @author Rick Mercer and Eduardo Hernandez
 */
public class PokerHand implements Comparable<PokerHand> {

	ArrayList<Card> hand;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		hand = new ArrayList<Card>();
		if (hand.contains(c1))
			throw new IllegalArgumentException();
		else
			hand.add(c1);
		if (hand.contains(c2))
			throw new IllegalArgumentException();
		else
			hand.add(c2);
		if (hand.contains(c3))
			throw new IllegalArgumentException();
		else
			hand.add(c3);
		if (hand.contains(c4))
			throw new IllegalArgumentException();
		else
			hand.add(c4);
		if (hand.contains(c5))
			throw new IllegalArgumentException();
		else
			hand.add(c5);
		Collections.sort(hand);
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < hand.size(); i++) {
			result += hand.get(i).toString() + " ";
		}
		return result;
	}

	public String handRank() {
		if (determineRankOfHand(this.hand) == 10)
			return "Royal Flush";
		if (determineRankOfHand(this.hand) == 9)
			return "Straight Flush";
		if (determineRankOfHand(this.hand) == 8)
			return "Four of a Kind";
		if (determineRankOfHand(this.hand) == 7)
			return "Full House";
		if (determineRankOfHand(this.hand) == 6)
			return "Flush";
		if (determineRankOfHand(this.hand) == 5)
			return "Straight";
		if (determineRankOfHand(this.hand) == 4)
			return "Three of a Kind";
		if (determineRankOfHand(this.hand) == 3)
			return "Two Pairs";
		if (determineRankOfHand(this.hand) == 2)
			return "One Pair";
		else
			return "High Card";
	}

	public int compareTo(PokerHand other) {
		int thisRank = determineRankOfHand(this.hand);
		int otherRank = determineRankOfHand(other.hand);
		if (thisRank != otherRank) {
			return Integer.compare(thisRank, otherRank);
		} else {
			return tieBreaker(this.hand, other.hand, thisRank);
		}
	}

	private int determineRankOfHand(ArrayList<Card> hand) {
		if (isRoyalFlush(hand)) {
			return 10;
		} else if (isStraightFlush(hand)) {
			return 9;
		} else if (isFourOfAKind(hand)) {
			return 8;
		} else if (isFullHouse(hand)) {
			return 7;
		} else if (isFlush(hand)) {
			return 6;
		} else if (isStraight(hand)) {
			return 5;
		} else if (isThreeOfAKind(hand)) {
			return 4;
		} else if (isTwoPair(hand)) {
			return 3;
		} else if (isOnePair(hand)) {
			return 2;
		} else {
			return 1;
		}
	}

	private boolean isRoyalFlush(ArrayList<Card> hand) {
		if (hand.get(4).getRank() != Rank.ACE || hand.get(0).getRank() != Rank.TEN) {
			return false;
		}
		Suit firstSuit = hand.get(0).getSuit();
		for (Card card : hand) {
			if (card.getSuit() != firstSuit) {
				return false;
			}
		}
		return true;
	}

	private boolean isStraightFlush(ArrayList<Card> hand) {
		return isStraight(hand) && isFlush(hand);
	}

	private boolean isFourOfAKind(ArrayList<Card> hand) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		for (Card card : hand) {
			Rank rank = card.getRank();
			if (!rankDict.containsKey(rank)) {
				rankDict.put(rank, 1);
			} else {
				rankDict.put(rank, rankDict.get(rank) + 1);
			}
		}
		for (Integer count : rankDict.values()) {
			if (count == 4) {
				return true;
			}
		}
		return false;
	}

	private boolean isFullHouse(ArrayList<Card> hand) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		for (Card card : hand) {
			Rank rank = card.getRank();
			if (!rankDict.containsKey(rank)) {
				rankDict.put(rank, 1);
			} else {
				rankDict.put(rank, rankDict.get(rank) + 1);
			}
		}
		boolean hasThreeOfAKind = false;
		boolean hasPair = false;
		for (Integer count : rankDict.values()) {
			if (count == 3) {
				hasThreeOfAKind = true;
			} else if (count == 2) {
				hasPair = true;
			}
		}
		return hasThreeOfAKind && hasPair;
	}

	private boolean isFlush(ArrayList<Card> hand) {
		Suit firstSuit = hand.get(0).getSuit();
		for (Card card : hand) {
			if (card.getSuit() != firstSuit) {
				return false;
			}
		}
		return true;
	}

	private boolean isStraight(ArrayList<Card> hand) {
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getRank().ordinal() + 1 != hand.get(i + 1).getRank().ordinal()) {
				return false;
			}
		}
		return true;
	}

	private boolean isThreeOfAKind(ArrayList<Card> hand) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		for (Card card : hand) {
			Rank rank = card.getRank();
			if (!rankDict.containsKey(rank)) {
				rankDict.put(rank, 1);
			} else {
				rankDict.put(rank, rankDict.get(rank) + 1);
			}
		}
		for (Integer count : rankDict.values()) {
			if (count == 3) {
				return true;
			}
		}
		return false;
	}

	private boolean isTwoPair(ArrayList<Card> hand) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		int pairCount = 0;
		for (Card card : hand) {
			Rank rank = card.getRank();
			if (!rankDict.containsKey(rank)) {
				rankDict.put(rank, 1);
			} else {
				rankDict.put(rank, rankDict.get(rank) + 1);
			}
		}
		for (Integer count : rankDict.values()) {
			if (count == 2) {
				pairCount++;
			}
		}
		return pairCount == 2;
	}

	private boolean isOnePair(ArrayList<Card> hand) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		for (Card card : hand) {
			Rank rank = card.getRank();
			if (!rankDict.containsKey(rank)) {
				rankDict.put(rank, 1);
			} else {
				rankDict.put(rank, rankDict.get(rank) + 1);
			}
		}
		for (Integer count : rankDict.values()) {
			if (count == 2) {
				return true;
			}
		}
		return false;
	}

	private int tieBreaker(ArrayList<Card> thisHand, ArrayList<Card> otherHand, int handRank) {
		if (handRank == 10 || handRank == 9 || handRank == 5 || handRank == 6 || handRank == 1) {
			return compareHighCard(thisHand, otherHand);
		} else if (handRank == 8 || handRank == 4 || handRank == 2) {
			return compareSets(thisHand, otherHand, handRank);
		} else if (handRank == 3) {
			return compareTwoPairs(thisHand, otherHand);
		} else {
			return compareFullHouse(thisHand, otherHand);
		}
	}

	private int compareTwoPairs(ArrayList<Card> thisHand, ArrayList<Card> otherHand) {
		ArrayList<Integer> thisHandPairs = new ArrayList<Integer>();
		ArrayList<Integer> otherHandPairs = new ArrayList<Integer>();
		Integer thisHandExtra = 0;
		Integer otherHandExtra = 0;
		for (int i = 0; i < 5; i++) {
			if (i != 4) {
				if (thisHand.get(i).getValue() == thisHand.get(i + 1).getValue())
					thisHandPairs.add(thisHand.get(i).getValue());
				if (otherHand.get(i).getValue() == otherHand.get(i + 1).getValue())
					otherHandPairs.add(otherHand.get(i).getValue());
			}
		}
		for (int i = 0; i < 5; i++) {
			if (!thisHandPairs.contains(thisHand.get(i).getValue()))
				thisHandExtra = thisHand.get(i).getValue();
			if (!otherHandPairs.contains(otherHand.get(i).getValue()))
				otherHandExtra = otherHand.get(i).getValue();
		}
		if (thisHandPairs.get(1) == otherHandPairs.get(1)) {
			if (thisHandPairs.get(0) == otherHandPairs.get(0)) {
				if (thisHandExtra > otherHandExtra) {
					return 1;
				} else if (thisHandExtra < otherHandExtra) {
					return -1;
				} else {
					return 0;
				}
			} else if (thisHandPairs.get(0) > otherHandPairs.get(0)) {
				return 1;
			} else {
				return -1;
			}
		} else if (thisHandPairs.get(1) > otherHandPairs.get(1)) {
			return 1;
		} else {
			return -1;
		}
	}

	private int compareHighCard(ArrayList<Card> thisHand, ArrayList<Card> otherHand) {
		for (int i = thisHand.size() - 1; i >= 0; i--) {
			int compareCard = thisHand.get(i).compareTo(otherHand.get(i));
			if (compareCard != 0) {
				return compareCard;
			}
		}
		return 0;
	}

	private int compareSets(ArrayList<Card> thisHand, ArrayList<Card> otherHand, int handRank) {
		int compareDecks = compareCardDecks(thisHand, otherHand, handRank);
		if (compareDecks != 0) {
			return compareDecks;
		}
		return compareOtherCardDecks(thisHand, otherHand, handRank);
	}

	private int compareCardDecks(ArrayList<Card> thisHand, ArrayList<Card> otherHand, int handRank) {
		Rank thisDeckRank = findDeckRank(thisHand, handRank);
		Rank otherDeckRank = findDeckRank(otherHand, handRank);
		int setComparison = thisDeckRank.compareTo(otherDeckRank);
		return setComparison;
	}

	private Rank findDeckRank(ArrayList<Card> thisHand, int handRank) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		for (Card card : thisHand) {
			Rank rank = card.getRank();
			if (rankDict.containsKey(rank)) {
				int currentCount = rankDict.get(rank);
				rankDict.put(rank, currentCount + 1);
			} else {
				rankDict.put(rank, 1);
			}
		}
		Rank firstPairRank = null;
		for (Rank rank : rankDict.keySet()) {
			int count = rankDict.get(rank);
			if (handRank == 2 && count == 2) {
				return rank;
			} else if (handRank == 4 && count == 3) {
				return rank;
			} else {
				if (count == 4) {
					firstPairRank = rank;
				}
			}
		}
		return firstPairRank;
	}

	private int compareOtherCardDecks(ArrayList<Card> thisHand, ArrayList<Card> otherHand, int handRank) {
		ArrayList<Card> thisRemaining = filterOutSetCards(thisHand, handRank);
		ArrayList<Card> otherRemaining = filterOutSetCards(otherHand, handRank);
		return compareHighCard(thisRemaining, otherRemaining);
	}

	private ArrayList<Card> filterOutSetCards(ArrayList<Card> thisHand, int handRank) {
		List<Rank> setRanks = getSetRanks(thisHand, handRank);
		ArrayList<Card> leftOverCards = new ArrayList<>();
		for (Card card : thisHand) {
			if (!setRanks.contains(card.getRank())) {
				leftOverCards.add(card);
			}
		}
		return leftOverCards;
	}

	private List<Rank> getSetRanks(ArrayList<Card> Hand, int handRank) {
		Map<Rank, Integer> rankDict = new HashMap<>();
		List<Rank> setRanks = new ArrayList<>();
		for (Card card : Hand) {
			Rank rank = card.getRank();
			if (rankDict.containsKey(rank)) {
				int currentCount = rankDict.get(rank);
				rankDict.put(rank, currentCount + 1);
			} else {
				rankDict.put(rank, 1);
			}
		}
		for (Rank rank : rankDict.keySet()) {
			int count = rankDict.get(rank);
			if ((handRank == 2 || handRank == 3) && count == 2) {
				setRanks.add(rank);
				if (handRank == 2)
					break;
			} else if ((handRank == 4 || handRank == 7) && count == 3) {
				setRanks.add(rank);
				if (handRank == 4)
					break;
			}
		}
		return setRanks;
	}

	private int compareFullHouse(ArrayList<Card> thisHand, ArrayList<Card> otherHand) {
		Rank thisThreeRank = findDeckRank(thisHand, 4);
		Rank otherThreeRank = findDeckRank(otherHand, 4);
		int threeComparison = thisThreeRank.compareTo(otherThreeRank);
		if (threeComparison != 0) {
			return threeComparison;
		}
		Rank thisPairRank = findDeckRank(thisHand, 2);
		Rank otherPairRank = findDeckRank(otherHand, 2);
		return thisPairRank.compareTo(otherPairRank);
	}
}
