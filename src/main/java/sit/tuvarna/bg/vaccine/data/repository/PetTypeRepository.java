package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.PetType;

import java.util.LinkedList;
import java.util.List;

public class PetTypeRepository implements DAORepository<PetType> {

    private static final Logger log = Logger.getLogger(PetTypeRepository.class);

    private static PetTypeRepository getInstance() {
        return PetTypeRepository.PetTypeRepositoryHolder.INSTANCE;
    }

    private static class PetTypeRepositoryHolder {
        public static PetTypeRepository INSTANCE = new PetTypeRepository();
    }


    @Override
    public void save(PetType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Pet type was saved successfully");
        } catch (Exception ex) {
            log.error("Pet type was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(PetType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Pet type was updated successfully");
        } catch (Exception ex) {
            log.error("Pet type was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(PetType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Pet type was deleted successfully");
        } catch (Exception ex) {
            log.error("Pet type was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public PetType getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<PetType> petTypeList = new LinkedList<PetType>();
        try {
            String jpql = "SELECT pt FROM PetType pt WHERE id_pet_type =" + id;
            petTypeList.addAll(session.createQuery(jpql, PetType.class).getResultList());
            log.info("Successfully gets all pet types");
        } catch (Exception ex) {
            log.error("Get ig pet type error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return petTypeList.get(0);
    }

    @Override
    public List<PetType> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<PetType> petTypeList = new LinkedList<PetType>();
        try {
            String jpql = "SELECT pt FROM PetType pt";
            petTypeList.addAll(session.createQuery(jpql, PetType.class).getResultList());
            log.info("Result all pet types");

        } catch (Exception ex) {
            log.error("Get pet type error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return petTypeList;
    }
}
