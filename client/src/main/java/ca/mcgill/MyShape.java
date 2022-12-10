package ca.mcgill;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MyShape extends HBox {

  public MyShape() {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("myshape.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // used to change the text in second label
  public void changeLabelText(String newText, int index) {
    // index 0: label 1, index 1: label 2.....
    Label secLabel = (Label) this.getChildren().get(index);
    secLabel.setText(newText);
  }

  private EventHandler<ActionEvent> buttonClick() {
    return event -> {
      Button curButton = (Button) event.getSource();
      curButton.setText("AAAA");
    };
  }

  public void addButton(String buttonText) {
    Button b = new Button(buttonText);
    this.getChildren().add(b);
    b.setOnAction(buttonClick());
  }
}
