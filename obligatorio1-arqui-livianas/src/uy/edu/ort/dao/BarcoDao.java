package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public interface BarcoDao {
    
    public void agregarBarco(Barco barco);

    public void borrarBarco(String codigo);
    
    public Barco obtenerBarco(String codigo);

    public List<Barco> listarBarcos();
    
}
