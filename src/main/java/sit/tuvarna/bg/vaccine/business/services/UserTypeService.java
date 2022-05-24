package sit.tuvarna.bg.vaccine.business.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sit.tuvarna.bg.vaccine.data.entities.User;
import sit.tuvarna.bg.vaccine.data.repository.UserRepository;
import sit.tuvarna.bg.vaccine.data.repository.UserTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserTypeService {

    private final UserTypeRepository repository=  UserTypeRepository.getInstance();


    public static  UserTypeService getInstance(){
        return  UserTypeService. UserTypeServiceHolder.INSTANCE;
    }



    private static class  UserTypeServiceHolder {

        public static final  UserTypeService INSTANCE = new  UserTypeService();
    }



}
