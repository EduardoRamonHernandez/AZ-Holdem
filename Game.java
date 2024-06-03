package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class Game that runs the game
 * 
 * @author Eduardo Hernandez
 */

public class Game {
	public Map<Integer, Player> gamePlayers;
	public CardDeck deck;
	public ArrayList<Card> communityCards;
	public int numPlayers;
	int pot;
	Scanner scanner;

	public Game() {
		deck = new CardDeck();
		ArrayList<Card> comCards = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			comCards.add(deck.getCard());
		}
		communityCards = comCards;
	}

	public String communityCardsToString() {
		PokerHand comCards = new PokerHand(communityCards.get(0), communityCards.get(1), communityCards.get(2),
				communityCards.get(3), communityCards.get(4));
		return comCards.toString();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		this.scanner = scanner;
		System.out.println("How many players? ");
		int numOfPlayers = scanner.nextInt();
		numPlayers = numOfPlayers;
		System.out.println("\nCommunity Cards: " + communityCardsToString());
		Map<Integer, Player> players = new HashMap<>();
		for (int i = 0; i < numPlayers; i++) {
			ArrayList<Card> hand = new ArrayList<Card>();
			hand.add(deck.getCard());
			hand.add(deck.getCard());
			Player player = new Player(hand, 98.0);
			players.put(i + 1, player);
		}
		gamePlayers = players;
		pot = numPlayers * 2;
		playGameHelp();
	}

	private void display() {
		for (Integer num : gamePlayers.keySet()) {
			Player player = gamePlayers.get(num);
			player.createBestHand(communityCards);
			System.out.println("\nPlayer " + num + ": $" + player.getEarnings() + "0 - " + player.getStartHand());
			System.out.println("    Best hand: " + player.getFinalHand() + "    " + player.getFinalHand().handRank());
		}
	}

	private void playGameHelp() {
		boolean playGame = true;
		while (playGame) {
			playGame();
			System.out.println("\nPlay another game? <y or n> ");
			String check = scanner.next();
			if (check.equals("y")) {
				playGame = true;
				restartGame();
			} else if (check.equals("n")) {
				playGame = false;
				endGame();
			}
		}
	}

	private void endGame() {
		scanner.close();
	}

	private List<Player> findWinners() {
		Map<Player, PokerHand> dictionary = new HashMap<>();
		for (Player player : gamePlayers.values()) {
			dictionary.put(player, player.getFinalHand());
		}
		PokerHand winningHand = Collections.max(dictionary.values());
		List<Player> winners = new ArrayList<>();
		for (Map.Entry<Player, PokerHand> entry : dictionary.entrySet()) {
			if (winningHand.compareTo(entry.getValue()) == 0) {
				Player winner = entry.getKey();
				winner.updateEarnings(true, pot / numPlayers);
				winners.add(winner);
			} else {
				entry.getKey().updateEarnings(false, 2);
			}
		}
		return winners;
	}

	public void playGame() {
		display();
		List<Player> winners = findWinners();
		if (winners.size() > 1) {
			System.out.println("\nWinning hands (tie)");
			for (int num : gamePlayers.keySet()) {
				if (winners.contains(gamePlayers.get(num))) {
					PokerHand hand = gamePlayers.get(num).getFinalHand();
					Player player = gamePlayers.get(num);
					System.out.println("\n" + hand.toString() + " " + hand.handRank() + " Player " + num + " $"
							+ player.getEarnings());
				}
			}
		} else {
			for (int num : gamePlayers.keySet()) {
				if (winners.contains(gamePlayers.get(num))) {
					PokerHand hand = gamePlayers.get(num).getFinalHand();
					Player player = gamePlayers.get(num);
					System.out.println("\nWinner: Player " + num + " $" + player.getEarnings());
					System.out.println(hand.toString() + "    " + hand.handRank());
					break;
				}
			}
		}
	}

	public void restartGame() {
		deck.resetDeck();
		ArrayList<Card> comCards = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			comCards.add(deck.getCard());
		}
		communityCards = comCards;
		System.out.println("\nCommunity Cards: " + communityCardsToString());
		for (Player player : gamePlayers.values()) {
			ArrayList<Card> hand = new ArrayList<Card>();
			hand.add(deck.getCard());
			hand.add(deck.getCard());
			player.startHand = hand;
			player.createBestHand(communityCards);
		}
	}
}
