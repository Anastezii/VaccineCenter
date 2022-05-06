package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.Client;

import java.util.LinkedList;
import java.util.List;

public class ClientRepository implements DAORepository<Client> {
    private static final Logger log = Logger.getLogger(ClientRepository.class);

    private static ClientRepository getInstance() {
        return ClientRepository.ClientRepositoryHolder.INSTANCE;
    }

    private static class ClientRepositoryHolder {
        public static ClientRepository INSTANCE = new ClientRepository();
    }

    @Override
    public void save(Client obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Client was saved successfully");
        } catch (Exception ex) {
            log.error("Client was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Client obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Client was updated successfully");
        } catch (Exception ex) {
            log.error("Client was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Client obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Client was deleted successfully");
        } catch (Exception ex) {
            log.error("Client was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Client getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Client> clients = new LinkedList<Client>();
        try {
            String jpql = "SELECT c FROM Client c WHERE id_client =" + id;
            clients.addAll(session.createQuery(jpql, Client.class).getResultList());
            log.info("Successfully gets all clients");

        } catch (Exception ex) {
            log.error("Get ig client error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return clients.get(0);
    }

    @Override
    public List<Client> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Client> clients = new LinkedList<Client>();
        try {
            String jpql = "SELECT c FROM Client c";
            clients.addAll(session.createQuery(jpql, Client.class).getResultList());
            log.info("Result all clients");

        } catch (Exception ex) {
            log.error("Get client error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return clients;
    }
}
