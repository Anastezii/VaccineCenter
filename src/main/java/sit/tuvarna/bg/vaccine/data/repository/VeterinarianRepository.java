package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.Veterinarian;

import java.util.LinkedList;
import java.util.List;

public class VeterinarianRepository implements DAORepository<Veterinarian> {
    private static final Logger log = Logger.getLogger(VeterinarianRepository.class);

    private static VeterinarianRepository getInstance() {
        return VeterinarianRepository.VeterinarianRepositoryHolder.INSTANCE;
    }

    private static class VeterinarianRepositoryHolder {
        public static VeterinarianRepository INSTANCE = new VeterinarianRepository();
    }

    @Override
    public void save(Veterinarian obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Veterinarian was saved successfully");
        } catch (Exception ex) {
            log.error("Veterinarian was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Veterinarian obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Veterinarian was updated successfully");
        } catch (Exception ex) {
            log.error("Veterinarian was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Veterinarian obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Veterinarian was deleted successfully");
        } catch (Exception ex) {
            log.error("Veterinarian was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Veterinarian getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Veterinarian> veterinarians = new LinkedList<Veterinarian>();
        try {
            String jpql = "SELECT v FROM Veterinarian v WHERE id_veterinarian =" + id;
            veterinarians.addAll(session.createQuery(jpql, Veterinarian.class).getResultList());
            log.info("Successfully gets all veterinarians");

        } catch (Exception ex) {
            log.error("Get ig veterinarian error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return veterinarians.get(0);
    }

    @Override
    public List<Veterinarian> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Veterinarian> veterinarians = new LinkedList<Veterinarian>();
        try {
            String jpql = "SELECT v FROM Veterinarian v";
            veterinarians.addAll(session.createQuery(jpql, Veterinarian.class).getResultList());
            log.info("Result all veterinarians");

        } catch (Exception ex) {
            log.error("Get veterinarian error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return veterinarians;
    }
}
