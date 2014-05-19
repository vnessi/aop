
package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi - Bruno Montaner
 */
public interface BarcoService {
    
    public void addBarco(Barco barco) throws BussinesException;

    public void removeBarco(Barco barco) throws BussinesException;
    
    public Barco obtenerBarco(String codigo) throws BussinesException;
    
    public void modifyBarco(Barco barco) throws BussinesException;    

    public List<Barco> listBarcos() throws BussinesException;
}
