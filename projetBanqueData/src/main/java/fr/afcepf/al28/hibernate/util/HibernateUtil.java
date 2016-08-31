package fr.afcepf.al28.hibernate.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
    static {
        	Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }

}
