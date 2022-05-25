package sit.tuvarna.bg.vaccine.presentation.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sit.tuvarna.bg.vaccine.business.services.VaccineService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class InputVaccineController {
    @FXML
    public DatePicker date;
    @FXML
    public TextField price;
    @FXML
    public TextField client_name;
    @FXML
    public TextField veterinarian_name;
    @FXML
    public TextField pet_name;
    @FXML
    public TextField vaccine_name;
    @FXML
    public Button InputButton;
    @FXML
    public Button ReturnButton;

private final VaccineService service=VaccineService.getInstance();

@FXML
    public void initialize(){

    ReturnButton.setOnMouseClicked(this::handle);
    InputButton.setOnMouseClicked(this::handle2);

}

    private void handle2(MouseEvent mouseEvent) {

        LocalDate DateVaccine=date.getValue();
        String priceVaccine=price.getText().trim();
        String client=client_name.getText().trim();
        String veterinar=veterinarian_name.getText().trim();
        String pet=pet_name.getText().trim();
        String vaccine=vaccine_name.getText().trim();
        if(!service.SaveVaccine(DateVaccine,priceVaccine,client,veterinar,pet,vaccine)){
            return ;
        }

        infoboxVaccine();

    }

    private void infoboxVaccine(){

        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Succesfully added vaccine"),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();

    }


    private void handle(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.views/VeterinsarProfile.fxml");
            root= FXMLLoader.load(pathAdminWindow);
            Stage stage=new Stage();
            stage.setTitle("Veterinar Window");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


}
