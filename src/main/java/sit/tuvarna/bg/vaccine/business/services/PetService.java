package sit.tuvarna.bg.vaccine.business.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sit.tuvarna.bg.vaccine.data.entities.Pet;
import sit.tuvarna.bg.vaccine.data.entities.User;
import sit.tuvarna.bg.vaccine.data.repository.PetRepository;
import sit.tuvarna.bg.vaccine.data.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PetService {

    private final PetRepository repository=  PetRepository.getInstance();


    public static  PetService getInstance(){
        return PetService. PetServiceHolder.INSTANCE;
    }


    private static class  PetServiceHolder {

        public static final  PetService INSTANCE = new  PetService();
    }

    public ObservableList<Pet> getAllTask(){
        List< Pet> pets=repository.getAll();
        return FXCollections.observableList(pets.stream().map(o->new Pet(o.getPet_name(),o.getPet_weight(),o.getPet_year_birth(),o.getPet_type(),
                o.getPet_sex(), o.getPet_category())).collect(Collectors.toList()));

    }

    public boolean ifPetExist(String petName){
        Pet petValue=repository.getPet(petName);
        if(petValue==null){

            return false;
        }
        else{
            return true;

        }

    }


}
