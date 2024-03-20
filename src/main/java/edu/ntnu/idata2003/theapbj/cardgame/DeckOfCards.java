package edu.ntnu.idata2003.theapbj.cardgame;

import java.util.ArrayList;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

/**
 * Represents a deck of 52 cards.
 *
 * @author Thea Pernille Bjartan
 * @version 2024-03-06
 */

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private ArrayList<PlayingCard> deck;

  /**
   * Constructs a new deck of cards.
   */
  public DeckOfCards() {
    deck = new ArrayList<PlayingCard>();
    for (char suit : suits) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new PlayingCard(suit, i));
      }
    }
  }


  /**
   * Deals a random number of cards from the deck.
   * @param n the number of cards to deal
   * @return a collection of cards
   * @throws IllegalArgumentException if n is negative or greater than the number of cards in the deck
   */
  public Hand dealHand(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number of cards to deal can not be negative.");
    }
    if (n > deck.size()) {
      throw new IllegalArgumentException("Number of cards to deal can not be greater than the number of cards in the deck.");
    }
    Hand hand = new Hand();
    for (int i = 0; i < n; i++) {
      int index = (int) (Math.random() * deck.size());
      hand.addCard(deck.get(index));
      deck.remove(index);
    }
    return hand;
  }

  /**
   * Returns the cards in the deck.
   * @return a collection of cards
   */
  public ArrayList<PlayingCard> getDeck() {
    return deck;
  }

}
