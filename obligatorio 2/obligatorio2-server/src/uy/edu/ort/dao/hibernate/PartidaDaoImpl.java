package uy.edu.ort.dao.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.dao.PartidaDao;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion de DAO Partida con Hibernate
 */
public class PartidaDaoImpl extends ObjectDaoImpl<Partida> implements PartidaDao {

    @Override
    public List<Contenedor> getContenedoresDePartidasFecha(Date d) throws DaoException {
        try {
            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
            List<Contenedor> c = hibernateTemplate.find("select a "
                    + "from Partida p "
                    + "left join p.contenedores as cont where p.fecha =" + dt1.format(d));
            if (c != null) {
                return c;
            }
        } catch (NullPointerException ex) {
        }
        return new ArrayList<>();
    }

    @Override
    public List<Partida> getPartidasEnMes(int mes) throws DaoException {
        return getPartidasEnMes(mes, null);
    }

    @Override
    public List<Partida> getPartidasEnMes(int mes, String codigoBarco) throws DaoException {
        String queryString = "from Partida p where month(p.fecha) = " + mes;

        if (codigoBarco != null) {
            queryString += " AND p.barco.id =" + codigoBarco;
        }
        return hibernateTemplate.find(queryString);
    }

    @Override
    public Boolean getPartidasBarcoHoy(long idBarco) throws DaoException {
        List<Partida> resultado;
        try {
             SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
              
            resultado = hibernateTemplate.find("from Partida where fecha =current_date and barco.id="+idBarco);
        } catch (Exception he) {
            throw new DaoException(he.getMessage());
        }
        return !resultado.isEmpty();
    }
    
}
