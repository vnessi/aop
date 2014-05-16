
package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public interface BarcoService {
    
    public void addBarco(Barco barco);

    public void removeBarco(Barco barco);

    public List<Barco> listBarcos();
}
