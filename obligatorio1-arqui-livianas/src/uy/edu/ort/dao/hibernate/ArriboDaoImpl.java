package uy.edu.ort.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class ArriboDaoImpl extends ObjectDaoImpl<Arribo> implements ArriboDao {

    @Override
    public List<Contenedor> getContenedoresDeArribosFecha(Date d) throws DaoException {
        try {
            List<Contenedor> c = hibernateTemplate.find("select contenedor "
                    + "from Arribo as a "
                    + "inner join a.Contenedor as contenedor where a.fecha =" + d);
            if (c != null) {
                return c;
            }
        } catch (NullPointerException ex) {
        }
        return new ArrayList<>();

    }

    @Override
    public List<Arribo> getArribosEnMes(int mes) throws DaoException {
        return getArribosEnMes(mes, null);
    }

    @Override
    public List<Arribo> getArribosEnMes(int mes, String codigoBarco) throws DaoException {
        String queryString = "from Arribo where MONTH(fecha) = " + mes;

        if (codigoBarco != null) {
            queryString += " AND barco.id =" + codigoBarco;
        }
        return hibernateTemplate.find(queryString);
    }

    @Override
    public Boolean getArriboBarcoHoy(String codigoBarco) throws DaoException {
        List<Arribo> resultado;
        try {
            Session session = HibernateUtil.iniciarTransaccion();
            String consulta = "from Arribo where fecha = :val";

            if (codigoBarco != null) {
                consulta += " AND barco.id = :codBarco";
            }

            Query query = session.createQuery(consulta);
            query.setParameter("val", new Date());
            query.setParameter("codBarco", codigoBarco);
            resultado = query.list();
        } catch (HibernateException he) {
            throw new DaoException(he.getMessage());
        } finally {
            HibernateUtil.cerrarTransaccion();
        }
        return !resultado.isEmpty();
    }
}
