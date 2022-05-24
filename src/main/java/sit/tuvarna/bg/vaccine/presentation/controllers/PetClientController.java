package sit.tuvarna.bg.vaccine.presentation.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PetClientController {
    @FXML
    public Button ReturnButton;

    @FXML
    private void initialize(){
        ReturnButton.setOnMouseClicked(this::handle);


    }

    private void handle(MouseEvent mouseEvent) {

        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.views/ProfileCl.fxml");
            root= FXMLLoader.load(pathAdminWindow);
            Stage stage=new Stage();
            stage.setTitle("Client Window");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }



}
