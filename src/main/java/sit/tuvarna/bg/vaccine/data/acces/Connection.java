package sit.tuvarna.bg.vaccine.data.acces;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static sit.tuvarna.bg.vaccine.data.acces.Connection.openSession;


public class Connection {

    private static final Logger log= Logger.getLogger(Connection.class);
    private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable ex){
            log.error("Initial SessionFactory created failed"+ex.getCause());
        }
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

    public static void closeSession(){
        sessionFactory.close();
    }

}
