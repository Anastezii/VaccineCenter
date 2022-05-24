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

public class VeterinarProfileController {
    @FXML
    public Button AllVaccineButton;
    @FXML
    public Button ReturnButton;
    @FXML
    public Button InputVaccineButton;

    @FXML
    private void initialize(){
        AllVaccineButton.setOnMouseClicked(this::handle);
        InputVaccineButton.setOnMouseClicked(this::handle2);
        ReturnButton.setOnMouseClicked(this::handle3);

    }

    private void handle3(MouseEvent mouseEvent) {

        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.views/hello-view.fxml");
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


    private void handle2(MouseEvent mouseEvent) {

        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.views/InputVaccine.fxml");
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


    private void handle(MouseEvent mouseEvent) {

        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.views/AllVaccine.fxml");
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
