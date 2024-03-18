package edu.ntnu.idata2003.theapbj.cardgame;


import java.util.ArrayList;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

/**
 * Represents a hand of cards.
 *
 * @author Thea Pernille Bjartan
 * @version 2024-03-18
 */
public class Hand {
  private ArrayList<PlayingCard> hand;
  private final char[] suits = {'S', 'H', 'D', 'C'};

  /**
   * Constructs a new hand of cards.
   */
  public Hand() {
    this.hand = new ArrayList<PlayingCard>();
  }

  /**
   * Adds a card to the hand.
   * @param card the card to add
   * @throws IllegalArgumentException if the card is null
   */
  public void addCard(PlayingCard card) {
    if (card == null) {
      throw new IllegalArgumentException("Card can not be null.");
    }
    this.hand.add(card);
  }

}
