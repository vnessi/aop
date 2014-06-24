package uy.edu.ort.dao.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion de DAO Arribo con Hibernate
 */
public class ArriboDaoImpl extends ObjectDaoImpl<Arribo> implements ArriboDao {

    @Override
    public List<Contenedor> getContenedoresDeArribosFecha(Date d) throws DaoException {
        try {
            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
            List<Contenedor> c = hibernateTemplate.find("select a "
                    + "from Arribo a "
                    + "left join a.contenedores as cont where a.fecha =" + dt1.format(d));
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
    public List<Arribo> getArribosEnMes(int mes, String idBarco) throws DaoException {
        String queryString = "from Arribo a where month(a.fecha) = " + mes;

        if (idBarco != null) {
            queryString += " AND a.barco.id =" + idBarco;
        }
        return hibernateTemplate.find(queryString);
    }

    @Override
    public Boolean getArriboBarcoHoy(long idBarco) throws DaoException {
        List<Arribo> resultado;
        try {
             SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
              
            resultado = hibernateTemplate.find("from Arribo where fecha =current_date and barco.id="+idBarco);
        } catch (Exception he) {
            throw new DaoException(he.getMessage());
        }
        return !resultado.isEmpty();
    }

    @Override
    public Boolean tieneArriboBarco(long idBarco) throws DaoException {
        List<Arribo> resultado;
        try {
             SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
              
            resultado = hibernateTemplate.find("from Arribo where fecha <=current_date and barco.id="+idBarco);
        } catch (Exception he) {
            throw new DaoException(he.getMessage());
        }
        return !resultado.isEmpty();
    }

}
