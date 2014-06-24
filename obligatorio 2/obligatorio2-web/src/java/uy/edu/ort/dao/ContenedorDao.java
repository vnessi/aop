
package uy.edu.ort.dao;

import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
public interface ContenedorDao extends ObjetoDao<Contenedor>{
    void modificar(long id, Contenedor barco) throws Exception;
}
