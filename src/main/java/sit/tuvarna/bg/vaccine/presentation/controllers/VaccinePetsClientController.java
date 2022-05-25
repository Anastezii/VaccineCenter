package sit.tuvarna.bg.vaccine.presentation.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sit.tuvarna.bg.vaccine.business.services.VaccineService;
import sit.tuvarna.bg.vaccine.data.entities.VaccineTime;

import java.io.IOException;
import java.net.URL;

public class VaccinePetsClientController {

    @FXML
    public Button ReturnButton;

    private final VaccineService service=VaccineService.getInstance();
    @FXML
    public TableView<VaccineTime> petVaccineList;
    @FXML
    public TableColumn<VaccineTime,String> date;
    @FXML
    public TableColumn<VaccineTime,String> price;
    @FXML
    public TableColumn<VaccineTime,String> petName;
    @FXML
    public TableColumn<VaccineTime,String> veterinar;
    @FXML
    public TableColumn<VaccineTime,String> vaccineType;

    @FXML
    private void initialize(){

        loadDate();
        ReturnButton.setOnMouseClicked(this::handle);

    }

    private void loadDate() {

        ObservableList<VaccineTime> vaccineTimesObservableList = service.getAllTaskClient();


        date.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getVaccine_date()));
        price.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getVaccine_price()));
        petName.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet().getPet_name()));
        veterinar.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getVeterinarian().getName()));
        vaccineType.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getVaccineSet().getVaccine_name()));

        petVaccineList.setItems(vaccineTimesObservableList);

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
