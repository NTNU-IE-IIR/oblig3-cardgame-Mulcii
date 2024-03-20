package edu.ntnu.idata2003.theapbj.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import org.junit.jupiter.api.Test;

/**
 * Test class for Hand.
 */
class HandTest {

  /**
   * Test that the constructor creates a hand with no cards.
   */
  @Test
  void testConstructor() {
    Hand hand = new Hand();
    assertEquals(0, hand.getHand().size());
  }

  /**
   * Test that the addCard method adds a card to the hand.
   */
  @Test
  void testAddCard() {
    Hand hand = new Hand();
    PlayingCard card = new PlayingCard('S', 1);
    hand.addCard(card);
    assertEquals(1, hand.getHand().size());
  }

  /**
   * Test that the addCard method throws an IllegalArgumentException when adding a null card.
   */
  @Test
  void testAddCardNull() {
    Hand hand = new Hand();
    assertThrows(IllegalArgumentException.class, () -> hand.addCard(null));
  }

  /**
   * Test that the getSumOfHand method returns the sum of the face values of the cards in the hand.
   */
  @Test
  void testGetSumOfHand() {
    Hand hand = new Hand();
    hand.addCard(new PlayingCard('S', 1));
    hand.addCard(new PlayingCard('H', 2));
    hand.addCard(new PlayingCard('D', 3));
    hand.addCard(new PlayingCard('C', 4));
    assertEquals(10, hand.getSumOfHand());
  }

  /**
   * Test that the getHearts method returns the hearts in the hand.
   */
  @Test
  void testGetHearts() {
    Hand hand = new Hand();
    hand.addCard(new PlayingCard('S', 1));
    hand.addCard(new PlayingCard('H', 2));
    hand.addCard(new PlayingCard('H', 3));
    hand.addCard(new PlayingCard('C', 4));
    assertEquals(2, hand.getHearts().size());
  }

  /**
   * Test that the isFlush method returns true if the hand is a flush, false otherwise.
   */
  @Test
  void testIsFlush() {
    Hand hand = new Hand();
    hand.addCard(new PlayingCard('S', 1));
    hand.addCard(new PlayingCard('S', 2));
    hand.addCard(new PlayingCard('S', 3));
    hand.addCard(new PlayingCard('S', 4));
    assertTrue(hand.isFlush());
  }

  /**
   * Test that the hasQSpades method returns true if the hand has the queen of spades, false otherwise.
   */
  @Test
  void testHasQSpades() {
    Hand hand = new Hand();
    hand.addCard(new PlayingCard('S', 1));
    hand.addCard(new PlayingCard('S', 2));
    hand.addCard(new PlayingCard('S', 3));
    hand.addCard(new PlayingCard('S', 4));
    assertFalse(hand.hasQSpades());
    hand.addCard(new PlayingCard('S', 12));
    assertTrue(hand.hasQSpades());
  }

  /**
   * Test that the getHand method returns the cards in the hand.
   */
  @Test
  void testGetHand() {
    Hand hand = new Hand();
    PlayingCard card = new PlayingCard('S', 1);
    hand.addCard(card);
    assertEquals(1, hand.getHand().size());
    assertTrue(hand.getHand().contains(card));
  }

}

