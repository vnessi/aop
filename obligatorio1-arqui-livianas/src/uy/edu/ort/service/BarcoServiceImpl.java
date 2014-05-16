
package uy.edu.ort.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class BarcoServiceImpl implements BarcoService {

    BarcoDao barcoDao;
    
    public BarcoServiceImpl(BarcoDao b){
        this.barcoDao = b;
    }
    
    @Override
    public void addBarco(Barco barco) {
        try {
            barcoDao.guardar(barco);
        } catch (GenericException ex) {
            //Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeBarco(Barco barco) {
            
    }

    @Override
    public List<Barco> listBarcos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
