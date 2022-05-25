package sit.tuvarna.bg.vaccine.business.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sit.tuvarna.bg.vaccine.data.entities.*;
import sit.tuvarna.bg.vaccine.data.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineService {

    private final VaccineTimeRepository repository=  VaccineTimeRepository.getInstance();
    private  final PetRepository petRepository=PetRepository.getInstance();
    private  final ClientRepository clientRepository=ClientRepository.getInstance();
    private  final VeterinarianRepository veterRepository=VeterinarianRepository.getInstance();
    private  final VaccineRepository vaccineRepository=VaccineRepository.getInstance();


    public static  VaccineService getInstance(){
        return VaccineService.VaccineServiceHolder.INSTANCE;
    }


    private static class  VaccineServiceHolder {

        public static final  VaccineService INSTANCE = new  VaccineService();
    }

    public boolean SaveVaccine(LocalDate date,String price,String client,String  veterinarian,String petString,String vaccine){

        VaccineTime vaccineTime=new VaccineTime();
        vaccineTime.setVaccine_price(price);
        vaccineTime.setVaccine_date(date);

       Pet petValue=petRepository.getPet(petString);
        if(petValue==null){
            infoboxPet();
            return false;
        }
        else{
           vaccineTime.setPet(petValue);

        }

        Client clientValue =clientRepository.getClient(client);
        if(clientValue==null){
            infoboxClient();
            return false;
        }
        else{
            vaccineTime.setClient(clientValue);

        }

        Veterinarian veterValue =veterRepository.getVetir(veterinarian);
        if(veterValue==null){
            infoboxVeter();
            return false;
        }
        else{
            vaccineTime.setVeterinarian(veterValue);

        }


        Vaccine vaccineValue =vaccineRepository.getVaccine(vaccine);
        if(vaccineValue==null){
            infoboxVaccine();
            return false;
        }
        else{
            vaccineTime.setVaccineSet(vaccineValue);

        }

        try{
            repository.save(vaccineTime);}
        catch(Exception ex ){
            ex.getCause();
        }
        return true;

    }

    private void infoboxVaccine() {

        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct vaccine type please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();

    }

    private void infoboxVeter() {

        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct veterinarian name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();

    }

    private void infoboxClient() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct client name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();

    }

    private void infoboxPet() {

        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct pet name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();

    }

    public ObservableList<VaccineTime> getAllTask(){
        List< VaccineTime> vaccineTimes=repository.getAll();
        return FXCollections.observableList(vaccineTimes.stream().map(o->new VaccineTime(o.getVaccine_price(),o.getVaccine_date(),o.getPet(),
                o.getClient(),o.getVaccineSet(),o.getVeterinarian())).collect(Collectors.toList()));

    }

    public ObservableList<VaccineTime> getAllTaskClient(){
        List< VaccineTime> vaccineTimes=repository.getAll();
        return FXCollections.observableList(vaccineTimes.stream().map(o->new VaccineTime(o.getVaccine_price(),o.getVaccine_date(),o.getPet(),
                o.getVaccineSet(),o.getVeterinarian())).collect(Collectors.toList()));

    }

}
