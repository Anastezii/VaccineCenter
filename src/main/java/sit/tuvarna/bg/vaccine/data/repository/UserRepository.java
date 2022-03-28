package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.User;

import java.util.LinkedList;
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

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("User was saved succesfully");
        }catch(Exception ex){
            log.error("User was not saved, error ("+ex.getCause());
        }finally{
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(User obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("User was updated succesfully");
        }catch(Exception ex){
            log.error("User was not updated, error ("+ex.getCause());
        }finally{
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(User obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("User was deleted succesfully");
        }catch(Exception ex){
            log.error("User was not deleted, error ("+ex.getCause());
        }finally{
            transaction.commit();
        }
        session.close();
    }

    @Override
    public User getById(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<User> users=new LinkedList<User>() ;
        try{
            String jpql="SELECT u FROM User u WHERE id_user ="+id;
            users.addAll(session.createQuery(jpql,User.class).getResultList());
            log.info("Succesfully gets all users");

        }catch (Exception ex){
            log.error("Get ig user error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return users.get(0);
    }

    @Override
    public List<User> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<User> users=new LinkedList<User>() ;
        try{
            String jpql="SELECT u FROM User u";
            users.addAll(session.createQuery(jpql,User.class).getResultList());
            log.info("Result all users");

        }catch (Exception ex){
            log.error("Get user error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return users;
    }


}
