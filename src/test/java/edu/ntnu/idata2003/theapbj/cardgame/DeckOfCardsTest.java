package edu.ntnu.idata2003.theapbj.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for DeckOfCards.
 */
class DeckOfCardsTest {

/**
   * Test that the constructor creates a deck with 52 cards.
   */
  @Test
  void testConstructor() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getDeck().size());
  }

  /**
   * Test that the dealHand method deals 5 cards from the deck.
   */
  @Test
  void testDealHand() {
    DeckOfCards deck = new DeckOfCards();
    Hand hand = deck.dealHand(5);
    assertEquals(5, hand.getHand().size());
  }

  /**
   * Test that the dealHand method throws an IllegalArgumentException when dealing a negative number of cards.
   */
  @Test
  void testDealHandNegative() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(-1));
  }

  /**
   * Test that the dealHand method throws an IllegalArgumentException when dealing more cards than there are in the deck.
   */
  @Test
  void testDealHandTooMany() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
  }


}