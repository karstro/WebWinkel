package web.winkel.webwinkel;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil () {
        // Constructor
    }
 
	private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration config = new Configuration();
            // apply properties from hibernate.cfg.xml
            config.configure();
            Properties configProperties = config.getProperties();
            // create a StandardServiceRegistry
            StandardServiceRegistryBuilder serviceRegisteryBuilder = new StandardServiceRegistryBuilder();
            ServiceRegistry serviceRegistry = serviceRegisteryBuilder.applySettings(configProperties).build();
            // build the sessionFactory using the config and service registry
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
	    }
	    return sessionFactory;
	}
 
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
    
    public static void saveObject(Object object) {
        Transaction tx = null;
        //Get the session object.
        Session session = sessionFactory.openSession();
        try{
            //Start hibernate session.
            tx = session.beginTransaction();

            // save the object
            session.save(object); 
    
            //Commit hibernate transaction if no exception occurs.
            tx.commit();
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs. 
                tx.rollback();
            }
            e.printStackTrace(); 
        }finally {
            //Close hibernate session.
            session.close(); 
        }
    }
}