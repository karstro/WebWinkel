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

    public static List<Object> getSQLResults(String query) {
        List<Object> result = null;
        Session session = null;
        try {
            // Start hibernate session.
            session = sessionFactory.openSession();

            // Get the object
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