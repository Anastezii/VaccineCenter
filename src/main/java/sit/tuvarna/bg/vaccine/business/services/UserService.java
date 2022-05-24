package sit.tuvarna.bg.vaccine.business.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sit.tuvarna.bg.vaccine.data.entities.User;
import sit.tuvarna.bg.vaccine.data.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepository repository=  UserRepository.getInstance();


    public static  UserService getInstance(){
        return  UserService. UserServiceHolder.INSTANCE;
    }



    private static class  UserServiceHolder {

        public static final  UserService INSTANCE = new  UserService();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  UserService)) return false;
        UserService that = ( UserService) o;
        return repository.equals(that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }


    public ObservableList<User> getAllTask(String login, String pass){
        List< User> users=repository.getLogin(login,pass);
        return FXCollections.observableList(users.stream().map(o->new User(o.getLogin(),
                o.getPassword())).collect(Collectors.toList()));

    }




}
