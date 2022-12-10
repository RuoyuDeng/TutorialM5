package ca.mcgill;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
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
}
