
package uy.edu.ort.dao.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class BarcoDaoImpl implements BarcoDao{

    private HibernateTemplate hibernateTemplate;
    
     public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Override
    public void guardar(Barco entity) throws DaoException {
        try{
            hibernateTemplate.save(entity);
        } catch (HibernateException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void borrar(Barco entity) throws DaoException {
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
    public Barco obtenerPorPK(Object id) throws DaoException {
        List<Barco> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Barco where id = :val";
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
    public List<Barco> obtenerTodos() throws DaoException {
        List<Barco> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Barco";
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
    public List<Barco> obtenerPorPropiedad(String prop, Object val) throws DaoException {
        List<Barco> resultado;
        try 
        { 
            Session session = HibernateUtil.iniciarTransaccion();
            
            String consulta = "from Barco where " + prop + " = :val";
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