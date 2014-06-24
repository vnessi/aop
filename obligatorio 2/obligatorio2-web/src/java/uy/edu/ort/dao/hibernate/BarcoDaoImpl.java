
package uy.edu.ort.dao.hibernate;

import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion que utiliza los DAO Hibernate de ObjetoDaoImpl
 */
public class BarcoDaoImpl extends ObjectDaoImpl<Barco> implements BarcoDao{
    
    @Override
    public void modificar(long id, Barco barco) throws Exception{
        try {
            Barco b = obtenerPorPropiedad("id", id).get(0);
            b.setAnioFabricacion(barco.getAnioFabricacion());
            b.setBandera(barco.getBandera());
            b.setCantidadTripulantes(barco.getCantidadTripulantes());
            b.setCapacidadTransporte(barco.getCapacidadTransporte());
            b.setCodigo(barco.getCodigo());
            b.setNombre(barco.getNombre());
            hibernateTemplate.merge(b);
        
        } catch (GenericException ex) {
            throw ex;
        }
    }
}
