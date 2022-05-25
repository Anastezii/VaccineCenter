package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.VaccineTime;

import java.util.LinkedList;
import java.util.List;

public class VaccineTimeRepository implements DAORepository<VaccineTime> {
    private static final Logger log = Logger.getLogger(VaccineTimeRepository.class);

    public static VaccineTimeRepository getInstance() {
        return VaccineTimeRepository.VaccineTimeRepositoryHolder.INSTANCE;
    }

    private static class VaccineTimeRepositoryHolder {
        public static VaccineTimeRepository INSTANCE = new VaccineTimeRepository();
    }

    @Override
    public void save(VaccineTime obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Vaccine time was saved successfully");
        } catch (Exception ex) {
            log.error("Vaccine time not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(VaccineTime obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Vaccine time was updated successfully");
        } catch (Exception ex) {
            log.error("Vaccine time was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(VaccineTime obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Vaccine time was deleted successfully");
        } catch (Exception ex) {
            log.error("Vaccine time was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public VaccineTime getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<VaccineTime> vaccineTimeList = new LinkedList<VaccineTime>();
        try {
            String jpql = "SELECT vt FROM VaccineTime vt WHERE id_vaccine_time =" + id;
            vaccineTimeList.addAll(session.createQuery(jpql, VaccineTime.class).getResultList());
            log.info("Successfully gets all Vaccine times");

        } catch (Exception ex) {
            log.error("Get ig Vaccine time error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return vaccineTimeList.get(0);
    }

    @Override
    public List<VaccineTime> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<VaccineTime> vaccineTimeList = new LinkedList<VaccineTime>();
        try {
            String jpql = "SELECT vt FROM VaccineTime vt";
            vaccineTimeList.addAll(session.createQuery(jpql, VaccineTime.class).getResultList());
            log.info("Result all vaccine times");

        } catch (Exception ex) {
            log.error("Get vaccine time error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return vaccineTimeList;
    }
}
