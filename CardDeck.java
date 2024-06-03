package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class containing all cards and methods for accessing and shuffling the deck.
 * 
 * @author Eduardo Hernandez
 */

public class CardDeck {
	ArrayList<Card> CardDeck;

	public CardDeck() {
		initializeDeck();
	}

	public void initializeDeck() {
		Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card C3 = new Card(Rank.THREE, Suit.CLUBS);
		Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
		Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
		Card C6 = new Card(Rank.SIX, Suit.CLUBS);
		Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
		Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card C9 = new Card(Rank.NINE, Suit.CLUBS);
		Card C10 = new Card(Rank.TEN, Suit.CLUBS);
		Card CJ = new Card(Rank.JACK, Suit.CLUBS);
		Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
		Card CK = new Card(Rank.KING, Suit.CLUBS);
		Card CA = new Card(Rank.ACE, Suit.CLUBS);

		Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
		Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
		Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
		Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
		Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
		Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
		Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
		Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
		Card DK = new Card(Rank.KING, Suit.DIAMONDS);
		Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

		Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
		Card H3 = new Card(Rank.THREE, Suit.HEARTS);
		Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
		Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
		Card H6 = new Card(Rank.SIX, Suit.HEARTS);
		Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
		Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
		Card H9 = new Card(Rank.NINE, Suit.HEARTS);
		Card H10 = new Card(Rank.TEN, Suit.HEARTS);
		Card HJ = new Card(Rank.JACK, Suit.HEARTS);
		Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
		Card HK = new Card(Rank.KING, Suit.HEARTS);
		Card HA = new Card(Rank.ACE, Suit.HEARTS);

		Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
		Card S3 = new Card(Rank.THREE, Suit.SPADES);
		Card S4 = new Card(Rank.FOUR, Suit.SPADES);
		Card S5 = new Card(Rank.FIVE, Suit.SPADES);
		Card S6 = new Card(Rank.SIX, Suit.SPADES);
		Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
		Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
		Card S9 = new Card(Rank.NINE, Suit.SPADES);
		Card S10 = new Card(Rank.TEN, Suit.SPADES);
		Card SJ = new Card(Rank.JACK, Suit.SPADES);
		Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
		Card SK = new Card(Rank.KING, Suit.SPADES);
		Card SA = new Card(Rank.ACE, Suit.SPADES);

		ArrayList<Card> deck = new ArrayList<>();

		deck.add(SA);
		deck.add(SK);
		deck.add(SQ);
		deck.add(SJ);
		deck.add(S10);
		deck.add(S9);
		deck.add(S8);
		deck.add(S7);
		deck.add(S6);
		deck.add(S5);
		deck.add(S4);
		deck.add(S3);
		deck.add(S2);

		deck.add(HA);
		deck.add(HK);
		deck.add(HQ);
		deck.add(HJ);
		deck.add(H10);
		deck.add(H9);
		deck.add(H8);
		deck.add(H7);
		deck.add(H6);
		deck.add(H5);
		deck.add(H4);
		deck.add(H3);
		deck.add(H2);

		deck.add(DA);
		deck.add(DK);
		deck.add(DQ);
		deck.add(DJ);
		deck.add(D10);
		deck.add(D9);
		deck.add(D8);
		deck.add(D7);
		deck.add(D6);
		deck.add(D5);
		deck.add(D4);
		deck.add(D3);
		deck.add(D2);

		deck.add(CA);
		deck.add(CK);
		deck.add(CQ);
		deck.add(CJ);
		deck.add(C10);
		deck.add(C9);
		deck.add(C8);
		deck.add(C7);
		deck.add(C6);
		deck.add(C5);
		deck.add(C4);
		deck.add(C3);
		deck.add(C2);
		CardDeck = deck;
		shuffleDeck();
	}

	public Card getCard() {
		if (CardDeck.isEmpty()) {
			resetDeck();
		}
		Card rndmCard = CardDeck.get(CardDeck.size() - 1);
		CardDeck.remove(rndmCard);
		return rndmCard;
	}

	public void resetDeck() {
		initializeDeck();
	}

	private void shuffleDeck() {
		Collections.shuffle(CardDeck);
	}
}
