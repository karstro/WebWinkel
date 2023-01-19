package web.winkel.webwinkel;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import java.util.List;

public class HibernateUtil {
    
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil () {}
 
    // try to build the session factory, report any errors that occured
	private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            // apply properties from hibernate.cfg.xml
            Configuration config = new Configuration();
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
    
    // save a POJO to the database using a session
    public static Boolean saveObject(Object object) {
        Boolean success = false;
        Transaction tx = null;
        Session session = null;
        try {
            // Start hibernate session.
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // save the object
            session.save(object); 
    
            // Commit hibernate transaction if no exception occurs.
            tx.commit();
            success = true;
        } catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs. 
                tx.rollback();
            }
            e.printStackTrace(); 
        } finally {
            //Close hibernate session.
            if (session != null) {
                session.close();
            }
        }
        return success;
    }
    
    // get an object with a certain type and id
    public static Object getObject(Class clazz, int id) {
        Object object = null;
        Session session = null;
        try {
            // Start hibernate session.
            session = sessionFactory.openSession();

            // Get the object
            object = session.get(clazz, id);
        } catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            // Close hibernate session.
            if (session != null) {
                session.close();
            }
        }
        return object;
    }

    // execute an SQL query in the database and return the results as a list of POJOs
    public static List<Object> getSQLResults(String query) {
        List<Object> result = null;
        Session session = null;
        try {
            // Start hibernate session.
            session = sessionFactory.openSession();

            // Get the objects
            result = (List<Object>)session.createSQLQuery(query).list();
        } catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            // Close hibernate session.
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
}