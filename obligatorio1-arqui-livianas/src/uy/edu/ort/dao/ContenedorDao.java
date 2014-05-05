
package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public interface ContenedorDao {
    public void agregarContenedor(Contenedor contenedor);

    public void borrarContenedor(String codigo);
    
    public Contenedor obtenerContenedor(String codigo);

    public List<Contenedor> listarContenedores();
}
