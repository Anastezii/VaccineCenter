package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.User;

import java.util.LinkedList;
import java.util.List;

public class UserRepository implements DAORepository<User> {

    private static final Logger log = Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance() {
        return UserRepository.UserRepositoryHolder.INSTANCE;
    }

    private static class UserRepositoryHolder {
        public static UserRepository INSTANCE = new UserRepository();
    }

    @Override
    public void save(User obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("User was saved successfully");
        } catch (Exception ex) {
            log.error("User was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(User obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("User was updated successfully");
        } catch (Exception ex) {
            log.error("User was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(User obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("User was deleted successfully");
        } catch (Exception ex) {
            log.error("User was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public User getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = new LinkedList<User>();
        try {
            String jpql = "SELECT u FROM User u WHERE id_user =" + id;
            users.addAll(session.createQuery(jpql, User.class).getResultList());
            log.info("Successfully gets all users");

        } catch (Exception ex) {
            log.error("Get ig user error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return users.get(0);
    }

    @Override
    public List<User> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = new LinkedList<User>();
        try {
            String jpql = "SELECT u FROM User u";
            users.addAll(session.createQuery(jpql, User.class).getResultList());
            log.info("Result all users");

        } catch (Exception ex) {
            log.error("Get user error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return users;
    }

    public List<User> getLogin(String login,String pass){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<User> admins =new LinkedList<User>() ;
        try{
            String jpql="SELECT t FROM User t WHERE t.login= :login AND t.password= :pass ";
            admins.addAll(session.createQuery(jpql, User.class).setParameter("login",login).
                    setParameter("pass",pass).getResultList());
            log.info("Result all users which matched.");

        }catch (Exception ex){
            log.error("Get users error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
        return admins;
    }


}
