package edu.ntnu.idata2003.theapbj.cardgame;

import java.io.FileNotFoundException;

public class CardGameController {
  private CardGameUi view;
  private DeckOfCards deck;
  private Hand hand;
  private int handSize;


  /**
   * Constructs a new controller for the card game.
   * @param view the user interface
   */
  public CardGameController(CardGameUi view) {
    this.view = view;
    this.deck = new DeckOfCards();
    this.handSize = 5;
  }


  /**
   * Creates a new deck of cards.
   */
  public void createDeck() {
    this.deck = new DeckOfCards();
  }

  /**
   * Deals a hand of cards.
   * Resets deck after each hand.
   * @throws FileNotFoundException if the image file is not found
   */
  public void dealHand() {
    try {
      this.hand = this.deck.dealHand(this.handSize);
      this.view.addToHand(this.hand);
      this.createDeck();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Checks the hand for the sum of the face values, hearts, flush and queen of spades.
   */
  public void checkHand() {
    this.view.setSumLabel(this.hand.getSumOfHand());
    this.view.setHeartString(this.hand.getHearts());
    this.view.setFlushResult(this.hand.isFlush());
    this.view.setQSpadeResult(this.hand.hasQSpades());
  }
}
