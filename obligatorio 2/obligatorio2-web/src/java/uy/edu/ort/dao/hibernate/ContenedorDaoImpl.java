
package uy.edu.ort.dao.hibernate;

import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.dao.ContenedorDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
public class ContenedorDaoImpl extends ObjectDaoImpl<Contenedor> implements ContenedorDao{

    @Override
    public void modificar(long id, Contenedor cont) throws Exception{
        try {
            Contenedor c = obtenerPorPropiedad("id", id).get(0);
            c.setCapacidad(cont.getCapacidad());
            c.setCodigo(cont.getCodigo());
            c.setMarca(cont.getMarca());
            c.setModelo(cont.getModelo());
        } catch (GenericException ex) {
            throw ex;
        }
    }

}
