package ca.mcgill;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PrimaryController implements Initializable {

    @FXML
    private Label textLabel;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Primary file has been loaded");
        // 1. URL: http://127.0.0.1:8080/online
        String newContent = null;
        try {
            newContent = Unirest.get("http://127.0.0.1:8080/online").asString().getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        textLabel.setText(newContent);
    }
}
