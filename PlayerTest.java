package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Card;
import model.Rank;
import model.Suit;
import model.Player;

/**
 * JUnit test for class Player with enums.
 * 
 * @author Eduardo Hernandez
 */

class PlayerTest {

	// This file contains all 52 cards to save you time with names like
	// C2 for the two of clubs
	// AS for the ace of spades

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	@Test
	void gettersTest() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(D8);
		givenHand.add(CA);
		Player player = new Player(givenHand, 98.00);
		assertEquals(98, player.getEarnings());
		System.out.println(player.getStartHand());
	}

	@Test
	void bestHandTest1() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(D8);
		givenHand.add(CA);
		Player player = new Player(givenHand, 98.00);
		ArrayList<Card> comCards = new ArrayList<>();
		comCards.add(C2);
		comCards.add(D9);
		comCards.add(S9);
		comCards.add(SK);
		comCards.add(C8);
		player.createBestHand(comCards);
		assertEquals(D8, player.getFinalHand().getHand().get(0));
		assertEquals(C8, player.getFinalHand().getHand().get(1));
		assertEquals(D9, player.getFinalHand().getHand().get(2));
		assertEquals(S9, player.getFinalHand().getHand().get(3));
		assertEquals(CA, player.getFinalHand().getHand().get(4));
	}

	@Test
	void bestHandTest2() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(C2);
		givenHand.add(S7);
		Player player = new Player(givenHand, 98.00);
		ArrayList<Card> comCards = new ArrayList<>();
		comCards.add(D10);
		comCards.add(CJ);
		comCards.add(SA);
		comCards.add(H5);
		comCards.add(C9);
		player.createBestHand(comCards);
		assertEquals(S7, player.getFinalHand().getHand().get(0));
		assertEquals(C9, player.getFinalHand().getHand().get(1));
		assertEquals(D10, player.getFinalHand().getHand().get(2));
		assertEquals(CJ, player.getFinalHand().getHand().get(3));
		assertEquals(SA, player.getFinalHand().getHand().get(4));
	}

	@Test
	void bestHandTest3() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(HQ);
		givenHand.add(H9);
		Player player = new Player(givenHand, 98.00);
		ArrayList<Card> comCards = new ArrayList<>();
		comCards.add(SQ);
		comCards.add(DQ);
		comCards.add(D9);
		comCards.add(S4);
		comCards.add(H10);
		player.createBestHand(comCards);
		assertEquals(H9, player.getFinalHand().getHand().get(0));
		assertEquals(D9, player.getFinalHand().getHand().get(1));
		assertEquals(HQ, player.getFinalHand().getHand().get(2));
		assertEquals(SQ, player.getFinalHand().getHand().get(3));
		assertEquals(DQ, player.getFinalHand().getHand().get(4));
	}

	@Test
	void winTest() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(HQ);
		givenHand.add(H9);
		Player player = new Player(givenHand, 98.00);
		ArrayList<Card> comCards = new ArrayList<>();
		comCards.add(SQ);
		comCards.add(DQ);
		comCards.add(D9);
		comCards.add(S4);
		comCards.add(H10);
		player.createBestHand(comCards);
		player.updateEarnings(true, 20);
		assertEquals(118.0, player.getEarnings());
	}

	@Test
	void lossTest() {
		ArrayList<Card> givenHand = new ArrayList<>();
		givenHand.add(HQ);
		givenHand.add(H9);
		Player player = new Player(givenHand, 98.00);
		ArrayList<Card> comCards = new ArrayList<>();
		comCards.add(SQ);
		comCards.add(DQ);
		comCards.add(D9);
		comCards.add(S4);
		comCards.add(H10);
		player.createBestHand(comCards);
		player.updateEarnings(false, 59);
		assertEquals(39.0, player.getEarnings());
	}
}
