package sit.tuvarna.bg.vaccine.presentation.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sit.tuvarna.bg.vaccine.presentation.models.HelloModel;

public class HelloController implements EventHandler<MouseEvent> {
    @FXML
    private Label welcomeText;

    @FXML
    private Button helloButton;

    private final HelloModel model;

    public HelloController() {
        this.model = new HelloModel();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void initialization(){
        helloButton.setOnMouseClicked(this::handle);

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        welcomeText.setText(model.getWelcomeMessage());
    }
}