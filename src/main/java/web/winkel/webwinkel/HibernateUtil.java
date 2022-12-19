package web.winkel.webwinkel;

import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil () {
        // Constructor
    }
 
	private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration config = new Configuration();
            // config.addAnnotatedClass(Customer.class);
            config.configure();
            Map configProperties = config.getProperties();
            StandardServiceRegistryBuilder serviceRegisteryBuilder = new StandardServiceRegistryBuilder();
            ServiceRegistry serviceRegistry = serviceRegisteryBuilder.applySettings(configProperties).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
	    }
	    return sessionFactory;
	}
 
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
 
}