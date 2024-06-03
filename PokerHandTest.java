package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified Sep 2015, June 2017, July 23, August
 * 23
 * 
 * I think this a pretty good unit test, if you add any other test cases please
 * send them to me!
 * 
 * I am providing all 52 possible Cars to save you time writing @Tests
 * 
 * @author Rick Mercer and Eduardo Hernandez
 */
public class PokerHandTest {

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
	public void testToString() {
		PokerHand hand = new PokerHand(CA, DK, HQ, SJ, C10);
		String expected = "10♣J♠Q♥K♦A♣";
		String actual = hand.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testHighCard1() {
		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
		PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testHighCard2() {
		PokerHand highCard1 = new PokerHand(D8, CA, H6, S4, C2);
		PokerHand highCard2 = new PokerHand(HA, D9, C5, S3, H2);
		System.out.println(highCard1.compareTo(highCard2));
		assertTrue(highCard1.compareTo(highCard2) < 0);
	}

	@Test
	public void testHighCard3() {
		PokerHand highCard1 = new PokerHand(D9, CA, H5, S3, C2);
		PokerHand highCard2 = new PokerHand(HA, D9, C5, S3, H2);
		assertTrue(highCard1.compareTo(highCard2) == 0);
	}

	@Test
	public void testRoyalFlush() {
		PokerHand royalFlush = new PokerHand(CA, CK, CQ, CJ, C10);
		PokerHand straightFlush = new PokerHand(D9, D8, D7, D6, D5);
		assertTrue(royalFlush.compareTo(straightFlush) > 0);
	}

	@Test
	public void testStraightFlush() {
		PokerHand straightFlush1 = new PokerHand(C6, C7, C8, C9, C10);
		PokerHand straightFlush2 = new PokerHand(D4, D5, D6, D7, D8);
		assertTrue(straightFlush1.compareTo(straightFlush2) > 0);
	}

	@Test
	public void testFourOfAKind1() {
		PokerHand fourOfAKind = new PokerHand(C4, D4, H4, S4, C10);
		PokerHand fullHouse = new PokerHand(C3, D3, H3, CJ, DJ);
		assertTrue(fourOfAKind.compareTo(fullHouse) > 0);
	}

	@Test
	public void testFourOfAKind2() {
		PokerHand fourOfAKind1 = new PokerHand(C4, D4, H4, S4, C10);
		PokerHand fourOfAKind2 = new PokerHand(C9, D9, H9, S9, DJ);
		assertTrue(fourOfAKind1.compareTo(fourOfAKind2) < 0);
	}

	@Test
	public void testFourOfAKind3() {
		PokerHand fourOfAKind = new PokerHand(C4, D4, H4, S4, C10);
		PokerHand fullHouse = new PokerHand(C3, D3, H3, CJ, DJ);
		assertTrue(fourOfAKind.compareTo(fullHouse) > 0);
	}

	@Test
	public void testFullHouse() {
		PokerHand fullHouse1 = new PokerHand(C3, D3, H3, CJ, DJ);
		PokerHand fullHouse2 = new PokerHand(C2, D2, H2, CA, DA);
		assertTrue(fullHouse1.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testFlush() {
		PokerHand flush1 = new PokerHand(C2, C6, C9, CJ, CK);
		PokerHand flush2 = new PokerHand(D3, D6, D7, D8, D10);
		assertTrue(flush1.compareTo(flush2) > 0);
	}

	@Test
	public void testStraight() {
		PokerHand straight1 = new PokerHand(C10, DJ, HQ, SK, CA);
		PokerHand straight2 = new PokerHand(D9, H10, CJ, SQ, DK);
		assertTrue(straight1.compareTo(straight2) > 0);
	}

	@Test
	public void testThreeOfAKind() {
		PokerHand threeOfAKind1 = new PokerHand(C3, D3, H3, C5, D6);
		PokerHand threeOfAKind2 = new PokerHand(C2, D2, H2, C8, D9);
		assertTrue(threeOfAKind1.compareTo(threeOfAKind2) > 0);
	}

	@Test
	public void testTwoPair() {
		PokerHand twoPair1 = new PokerHand(C3, D3, C6, D6, C9);
		PokerHand twoPair2 = new PokerHand(H3, S3, H4, S4, C7);
		assertTrue(twoPair1.compareTo(twoPair2) > 0);
	}

	@Test
	public void testOnePair() {
		PokerHand onePair1 = new PokerHand(CA, DA, C3, D4, H5);
		PokerHand onePair2 = new PokerHand(CA, DA, C2, D3, H4);
		assertTrue(onePair1.compareTo(onePair2) > 0);
	}

	@Test
	public void testOnePair2() {
		PokerHand pair1 = new PokerHand(D2, S2, C2, H3, DA);
		PokerHand pair2 = new PokerHand(C2, H2, D2, C3, CK);
		assertTrue(pair1.compareTo(pair2) > 0);

	}

	@Test
	public void testFullHouseComparison() {
		PokerHand fullHouse1 = new PokerHand(C3, D3, H3, CJ, DJ);
		PokerHand fullHouse2 = new PokerHand(C3, D3, H3, C2, D2);
		assertTrue(fullHouse1.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testFullHousePairIdentification() {
		PokerHand fullHouse1 = new PokerHand(C3, D3, H3, CJ, DJ);
		PokerHand fullHouse2 = new PokerHand(C3, D3, H3, C2, D2);
		assertTrue(fullHouse1.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testTwoPairComparison() {
		PokerHand twoPair1 = new PokerHand(SA, DA, HK, CK, SQ);
		PokerHand twoPair2 = new PokerHand(CA, HA, DK, SK, CJ);
		assertTrue(twoPair1.compareTo(twoPair2) > 0);
	}

	@Test
	public void testFullHouseComparisonWithCompletion() {
		PokerHand threeOfAKindHand = new PokerHand(HK, DK, CK, SA, HQ);
		PokerHand fullHouseHand = new PokerHand(HK, DK, CK, SA, HA);
		assertTrue(threeOfAKindHand.compareTo(fullHouseHand) < 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual2() {
		PokerHand a = new PokerHand(C8, D8, CA, SA, CK);
		PokerHand b = new PokerHand(H9, S9, HA, DA, HK);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual3() {
		PokerHand a = new PokerHand(C10, D10, CA, SA, C7);
		PokerHand b = new PokerHand(H10, S10, HA, DA, HK);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual4() {
		PokerHand a = new PokerHand(C9, D9, CA, SA, CK);
		PokerHand b = new PokerHand(H9, S9, HA, DA, HK);
		assertTrue(a.compareTo(b) == 0);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual5() {
		PokerHand a = new PokerHand(C8, D8, CQ, SQ, CK);
		PokerHand b = new PokerHand(H9, S9, HA, DA, HK);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}
}