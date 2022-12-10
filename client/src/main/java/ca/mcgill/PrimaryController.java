package ca.mcgill;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField userAgeTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Label displayZoneLabel;



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }


    private EventHandler<ActionEvent> submitUserInfo(Label displayZoneLabel) {
        return event -> {
            String userName = userNameTextField.getText();
            int userAge = Integer.parseInt(userAgeTextField.getText());
            try {
                String userResponse = Unirest.post("http://127.0.0.1:8080/users")
                    .queryString("username", userName)
                    .queryString("userage", userAge).asString().getBody();
                User curUser = new Gson().fromJson(userResponse, User.class);
                String userInfo =
                    String.format("User's name is %s, \n user's age is: %d", curUser.getUsername(), curUser.getUserage());
                displayZoneLabel.setText(userInfo);

            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("Primary file has been loaded");
        //// 1. URL: http://127.0.0.1:8080/online
        //String newContent = null;
        //try {
        //    newContent = Unirest.get("http://127.0.0.1:8080/online").asString().getBody();
        //} catch (UnirestException e) {
        //    throw new RuntimeException(e);
        //}
        //textLabel.setText(newContent);
        //MyShape myShape = new MyShape();
        //displayVbox.getChildren().add(myShape);
        //
        //myShape.changeLabelText("new text",0);
        //myShape.changeLabelText(newContent,2);
        //myShape.addButton("init button");
        //userNameTextField.setText("name");
        //userAgeTextField.setText("10");
        submitButton.setOnAction(submitUserInfo(displayZoneLabel));
    }

}
