
package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.Arribo;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public interface ArriboDao {
    public void agregarArribo(Arribo arribo);

    public void borrarArribo(String codigo);
    
    public Arribo obtenerArribo(String codigo);

    public List<Arribo> listarArribos();
}
