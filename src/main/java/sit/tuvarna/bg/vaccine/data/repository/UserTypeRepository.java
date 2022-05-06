package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.UserType;

import java.util.LinkedList;
import java.util.List;

public class UserTypeRepository implements DAORepository<UserType> {

    private static final Logger log = Logger.getLogger(UserTypeRepository.class);

    private static UserTypeRepository getInstance() {
        return UserTypeRepository.UserTypeRepositoryHolder.INSTANCE;
    }

    private static class UserTypeRepositoryHolder {
        public static UserTypeRepository INSTANCE = new UserTypeRepository();
    }

    @Override
    public void save(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("User type was saved successfully");
        } catch (Exception ex) {
            log.error("User type was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("User type was updated successfully");
        } catch (Exception ex) {
            log.error("User type was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("User type was deleted successfully");
        } catch (Exception ex) {
            log.error("User type was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public UserType getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserType> userTypeList = new LinkedList<UserType>();
        try {
            String jpql = "SELECT ut FROM UserType ut WHERE id_user_type =" + id;
            userTypeList.addAll(session.createQuery(jpql, UserType.class).getResultList());
            log.info("Successfully gets all user types");

        } catch (Exception ex) {
            log.error("Get ig user type error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return userTypeList.get(0);
    }

    @Override
    public List<UserType> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserType> userTypeList = new LinkedList<UserType>();
        try {
            String jpql = "SELECT ut FROM UserType ut";
            userTypeList.addAll(session.createQuery(jpql, UserType.class).getResultList());
            log.info("Result all user types");

        } catch (Exception ex) {
            log.error("Get user type error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return userTypeList;
    }
}
