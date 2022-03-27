package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import sit.tuvarna.bg.vaccine.data.entities.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<User>{


    private static final Logger log= Logger.getLogger(UserRepository.class);
    private static UserRepository getInstance(){return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static UserRepository INSTANCE=new UserRepository();
    }

    @Override
    public void save(User obj) {

    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(User obj) {

    }

    @Override
    public Optional<User> getById(User obj) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll(User obj) {
        return null;
    }


}
