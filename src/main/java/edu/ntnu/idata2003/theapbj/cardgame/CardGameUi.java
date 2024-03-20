package edu.ntnu.idata2003.theapbj.cardgame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

/**
 * Represents the user interface for the card game.
 *
 * @version 2024-03-18
 */
public class CardGameUi extends Application {

  private HBox cards;
  private Label sumResult;
  private Label sumHearts;
  private Label flushResult;
  private Label qSpadeResult;



  /**
   * Starts the application.
   * @param stage the primary stage
   * @throws Exception if an error occurs
   */
  @Override
  public void start(Stage stage) throws Exception {
    CardGameController controller = new CardGameController(this);

    BorderPane rootNode = new BorderPane();

    cards = new HBox();
    cards.setMinHeight(400);
    cards.setMinWidth(600);
    cards.setSpacing(10);
    cards.setBackground(Background.fill(Color.DARKGREEN));
    cards.alignmentProperty().set(Pos.CENTER);
    rootNode.setCenter(cards);

    VBox buttons = new VBox();
    buttons.setSpacing(10);
    buttons.setAlignment(Pos.CENTER);
    rootNode.setRight(buttons);

    Button deal = new Button("Deal Hand");
    deal.setMinWidth(90);
    buttons.getChildren().add(deal);
    deal.setOnAction(e -> controller.dealHand());

    Button check = new Button("Check Hand");
    check.setMinWidth(90);
    buttons.getChildren().add(check);
    check.setOnAction(e -> controller.checkHand());


    VBox cardInfo = new VBox();
    rootNode.setBottom(cardInfo);

    Label sumFaces = new Label("Sum of faces: ");
    sumFaces.setFont(new Font("Arial", 15));
    cardInfo.getChildren().add(sumFaces);

    sumResult = new Label(" ");
    sumResult.setFont(new Font("Arial", 13));
    cardInfo.getChildren().add(sumResult);

    Label hearts = new Label("Hearts: ");
    hearts.setFont(new Font("Arial", 15));
    cardInfo.getChildren().add(hearts);

    sumHearts = new Label(" ");
    sumHearts.setFont(new Font("Arial", 13));
    cardInfo.getChildren().add(sumHearts);

    Label flush = new Label("Flush: ");
    flush.setFont(new Font("Arial", 15));
    cardInfo.getChildren().add(flush);

    flushResult = new Label(" ");
    flushResult.setFont(new Font("Arial", 13));
    cardInfo.getChildren().add(flushResult);

    Label qSpade = new Label("Q of Spades: ");
    qSpade.setFont(new Font("Arial", 15));
    cardInfo.getChildren().add(qSpade);

    qSpadeResult = new Label(" ");
    qSpadeResult.setFont(new Font("Arial", 13));
    cardInfo.getChildren().add(qSpadeResult);


    stage.setTitle("Card Game");
    stage.setScene(new Scene(rootNode, 800, 400));
    stage.show();

  }

  /**
   * Adds the cards to the hand.
   * @param hand the hand of cards
   * @throws FileNotFoundException if the image file is not found
   */
  public void addToHand(Hand hand) throws FileNotFoundException{
    cards.getChildren().clear();
    for (PlayingCard card : hand.getHand()) {
      Image cardFace = new Image(new FileInputStream("src/main/resources/cards/" + card.getAsString() + ".png"));
      ImageView cardView = new ImageView(cardFace);
      cardView.setPreserveRatio(true);
      cardView.setFitHeight(200);
      cards.getChildren().add(cardView);
    }
  }

  /**
   * Sets the sum of the face values of the cards in the hand.
   * @param sumString the sum of the face values
   */
  public void setSumLabel(int sumString) {
    this.sumResult.setText(String.valueOf(sumString));
  }

  /**
   * Sets the hearts in the hand.
   * @param heartString the hearts in the hand
   */
  public void setHeartString(List<String> heartString) {
    StringBuilder sb = new StringBuilder();
    if (heartString.isEmpty()) {
      sb.append("None");
    }
    for (String s : heartString) {
      sb.append(s);
      sb.append(" ");
    }
    this.sumHearts.setText(sb.toString());
  }

  /**
   * Sets whether the hand is a flush.
   * @param isFlush true if the hand is a flush, false otherwise
   */
  public void setFlushResult(boolean isFlush) {
    this.flushResult.setText(String.valueOf(isFlush));
  }

  /**
   * Sets whether the hand has the queen of spades.
   * @param hasQSpades true if the hand has the queen of spades, false otherwise
   */
  public void setQSpadeResult(boolean hasQSpades) {
    this.qSpadeResult.setText(String.valueOf(hasQSpades));
  }



  /**
   * Launches the application.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
