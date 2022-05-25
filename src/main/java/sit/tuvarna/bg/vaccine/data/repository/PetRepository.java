package sit.tuvarna.bg.vaccine.data.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sit.tuvarna.bg.vaccine.data.acces.Connection;
import sit.tuvarna.bg.vaccine.data.entities.Pet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PetRepository implements DAORepository<Pet> {

    private static final Logger log = Logger.getLogger(PetRepository.class);

    public static PetRepository getInstance() {
        return PetRepository.PetRepositoryHolder.INSTANCE;
    }

    private static class PetRepositoryHolder {
        public static PetRepository INSTANCE = new PetRepository();
    }

    @Override
    public void save(Pet obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Pet was saved successfully");
        } catch (Exception ex) {
            log.error("Pet was not saved, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Pet obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Pet was updated successfully");
        } catch (Exception ex) {
            log.error("Pet was not updated, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Pet obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Pet was deleted successfully");
        } catch (Exception ex) {
            log.error("Pet was not deleted, error (" + ex.getCause());
        } finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Pet getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Pet> pets = new LinkedList<Pet>();
        try {
            String jpql = "SELECT p FROM Pet p WHERE id_pet =" + id;
            pets.addAll(session.createQuery(jpql, Pet.class).getResultList());
            log.info("Successfully gets all pets");

        } catch (Exception ex) {
            log.error("Get ig pet error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return pets.get(0);
    }

    @Override
    public List<Pet> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Pet> pets = new LinkedList<Pet>();
        try {
            String jpql = "SELECT p FROM Pet p";
            pets.addAll(session.createQuery(jpql, Pet.class).getResultList());
            log.info("Result all pets");

        } catch (Exception ex) {
            log.error("Get pet error : " + ex.getMessage());
        } finally {
            transaction.commit();
        }
        session.close();
        return pets;
    }

    public Pet getPet(String pet) {

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Pet> pets =new ArrayList<Pet>() ;

        try{
            String jpql="SELECT a FROM Pet a WHERE a.pet_name= :pet";

            pets.addAll(session.createQuery(jpql,Pet.class).
                    setParameter("pet",pet).getResultList());
            log.info("Succesfully get all pet");

        }catch (Exception ex){
            log.error("Get pet error : "+ex.getCause());
        }finally {
            transaction.commit();
            session.close();
        }
        if(pets.size()!=0){
            return pets.get(0);}
        else{
            return null;
        }

    }

}
