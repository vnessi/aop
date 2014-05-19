
package uy.edu.ort.dao;

import java.util.Date;
import java.util.List;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi - Bruno Montaner
 */
public interface ArriboDao extends ObjetoDao<Arribo>{
    
    public List<Contenedor> getContenedoresDeArribosFecha(Date d) throws DaoException;
    
    public List<Arribo> getArribosEnMes(int mes) throws DaoException;
    
    public List<Arribo> getArribosEnMes(int mes, String codigoBarco) throws DaoException;
    
    public Boolean getArriboBarcoHoy(String codigoBarco) throws DaoException;
}
