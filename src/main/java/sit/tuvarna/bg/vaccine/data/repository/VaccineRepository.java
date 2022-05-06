package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.Vaccine;

import java.util.LinkedList;
import java.util.List;

public class VaccineRepository implements DAORepository<Vaccine> {
    private static final Logger log = Logger.getLogger(VaccineRepository.class);

    private static VaccineRepository getInstance() {
        return VaccineRepository.VaccineRepositoryHolder.INSTANCE;
    }

    private static class VaccineRepositoryHolder {
        public static VaccineRepository INSTANCE = new VaccineRepository();
    }

    @Override
    public void save(Vaccine obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Vaccine was saved successfully");
        } catch (Exception ex) {
            log.error("Vaccine was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Vaccine obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Vaccine was updated successfully");
        } catch (Exception ex) {
            log.error("Vaccine was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Vaccine obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Vaccine was deleted successfully");
        } catch (Exception ex) {
            log.error("Vaccine was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Vaccine getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Vaccine> vaccines = new LinkedList<Vaccine>();
        try {
            String jpql = "SELECT v FROM Vaccine v WHERE id_vaccine =" + id;
            vaccines.addAll(session.createQuery(jpql, Vaccine.class).getResultList());
            log.info("Successfully gets all vaccines");

        } catch (Exception ex) {
            log.error("Get ig vaccine error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return vaccines.get(0);
    }

    @Override
    public List<Vaccine> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Vaccine> vaccines = new LinkedList<Vaccine>();
        try {
            String jpql = "SELECT v FROM Vaccine v";
            vaccines.addAll(session.createQuery(jpql, Vaccine.class).getResultList());
            log.info("Result all vaccines");

        } catch (Exception ex) {
            log.error("Get vaccine error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return vaccines;
    }
}
