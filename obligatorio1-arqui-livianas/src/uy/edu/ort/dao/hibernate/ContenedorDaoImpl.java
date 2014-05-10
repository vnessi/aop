
package uy.edu.ort.dao.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import uy.edu.ort.dao.ContenedorDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class ContenedorDaoImpl implements ContenedorDao{

    @Override
    public void guardar(Contenedor entity) throws GenericException {
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
    public void borrar(Contenedor entity) throws GenericException {
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
    public Contenedor obtenerPorPK(Object id) throws GenericException {
        List<Contenedor> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Contenedor where id = :val";
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
    public List<Contenedor> obtenerTodos() throws GenericException {
        List<Contenedor> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Contenedor";
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
    public List<Contenedor> obtenerPorPropiedad(String prop, Object val) throws GenericException {
        List<Contenedor> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Contenedor where " + prop + " = :val";
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
