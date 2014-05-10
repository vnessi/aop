package uy.edu.ort.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    static Transaction transaction;
    static Session session;
    
    public static Session iniciarTransaccion(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        session = sessionFactory.openSession();
        
        transaction = session.beginTransaction();
        
        return session;
    
    }
    
    public static void comitearTransaccion(){
        transaction.commit();
    }
    
    public static void cerrarTransaccion(){
        session.close();
    }
}
