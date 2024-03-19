package edu.ntnu.idata2003.theapbj.cardgame;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

  /**
   * Returns the cards in the hand.
   * @return a collection of cards
   */
  public Collection<PlayingCard> getHand() {
    return this.hand;
  }

  /**
   * Returns the sum of the face values of the cards in the hand.
   * @return the sum of the face values
   */
  public int getSumOfHand() {
    return this.hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Returns the hearts in the hand.
   * @return a collection of hearts
   */
  public List<String> getHearts() {
    return this.hand.stream().
        filter(card -> card.getSuit() == 'H')
        .map(card -> card.getFace() + String.valueOf(card.getFace()))
        .toList();
  }

  /**
   * Returns whether the hand is a flush.
   * @return true if the hand is a flush, false otherwise
   */
  public boolean isFlush() {
    return this.hand.stream().map(PlayingCard::getSuit).distinct().count() == 1;
  }

  /**
   * Returns whether the hand has the queen of spades.
   * @return true if the hand has the queen of spades, false otherwise
   */
  public boolean hasQSpades() {
    return this.hand.stream().anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }
}
