
package uy.edu.ort.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.User;
import uy.edu.ort.util.HibernateUtil;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class BarcoDaoImpl implements BarcoDao{

    @Override
    public void agregarBarco(Barco barco) {
        /*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
*/
        
        Session session = HibernateUtil.iniciarTransaccion();
        
        session.save(barco);

        HibernateUtil.cerrarTransaccion();
        
        /*transaction.commit();
        session.close();*/
    }

    @Override
    public void borrarBarco(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Barco obtenerBarco(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barco> listarBarcos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
