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
import sit.tuvarna.bg.vaccine.business.services.PetService;
import sit.tuvarna.bg.vaccine.data.entities.Pet;

import java.io.IOException;
import java.net.URL;

public class PetClientController {
    @FXML
    public Button ReturnButton;
    @FXML
    public TableView<Pet> tablePets;
    @FXML
    public TableColumn<Pet,String> pet_name;
    @FXML
    public TableColumn<Pet,String> pet_weight;
    @FXML
    public TableColumn<Pet,String> pet_year_birth;
    @FXML
    public TableColumn<Pet,String> sex;
    @FXML
    public TableColumn<Pet,String> category;
    @FXML
    public TableColumn<Pet,String> pet_type;


    private final PetService service=PetService.getInstance();


    @FXML
    private void initialize(){
        loadDate();
        ReturnButton.setOnMouseClicked(this::handle);


    }

    private void loadDate() {

        ObservableList<Pet> petsObservableList = service.getAllTask();


       pet_name.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_name()));
       pet_year_birth.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_year_birth()));
        pet_type.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_type().getPet_type_name()));
        pet_weight.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_weight()));
        category.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_category()));
        sex.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPet_sex()));

        tablePets.setItems(petsObservableList);

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
