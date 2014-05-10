
package uy.edu.ort.dao.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Arribo;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class ArriboDaoImpl implements ArriboDao{

    @Override
    public void guardar(Arribo entity) throws GenericException {
        try{
            Session session = HibernateUtil.iniciarTransaccion();

            session.save(entity);

            HibernateUtil.comitearTransaccion();
        } catch (HibernateException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            HibernateUtil.cerrarTransaccion();
        } 
    }

    @Override
    public void borrar(Arribo entity) throws GenericException {
        try{
            Session session = HibernateUtil.iniciarTransaccion();

            session.delete(entity);

            HibernateUtil.comitearTransaccion();
            HibernateUtil.cerrarTransaccion();
        } catch (HibernateException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            HibernateUtil.cerrarTransaccion();
        } 
    }

    @Override
    public Arribo obtenerPorPK(Object id) throws GenericException {
        List<Arribo> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Arribo where id = :val";
            Query query = session.createQuery(consulta);
            query.setParameter("val", (Long)id);
            resultado = query.list();
        } catch (HibernateException he) 
        { 
            throw new DaoException(he.getMessage());
        } finally 
        { 
            HibernateUtil.cerrarTransaccion();
        }  
        return resultado.get(0);
    }

    @Override
    public List<Arribo> obtenerTodos() throws GenericException {
        List<Arribo> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Arribo";
            Query query = session.createQuery(consulta);
            resultado = query.list();
        } catch (HibernateException he) 
        { 
            throw new DaoException(he.getMessage());
        } finally 
        { 
            HibernateUtil.cerrarTransaccion();
        }  
        return resultado;
    }

    @Override
    public List<Arribo> obtenerPorPropiedad(String prop, Object val) throws GenericException {
        List<Arribo> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Arribo where " + prop + " = :val";
            Query query = session.createQuery(consulta);
            query.setParameter("val", (String)val);
            resultado = query.list();
        } catch (HibernateException he) 
        { 
            throw new DaoException(he.getMessage());
        } finally 
        { 
            HibernateUtil.cerrarTransaccion();
        }  
        return resultado;
    }
    
}
