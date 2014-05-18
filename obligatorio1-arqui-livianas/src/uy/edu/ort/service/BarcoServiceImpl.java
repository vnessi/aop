package uy.edu.ort.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class BarcoServiceImpl implements BarcoService {

    BarcoDao barcoDao;
    ArriboDao arriboDao;
    
    public void setBarcoDao(BarcoDao b){
        this.barcoDao = b;
    }
    
    public void setArriboDao(ArriboDao a){
        this.arriboDao = a;
    }
    
    @Override
    public void addBarco(Barco barco) throws BussinesException {
        try {
            barcoDao.guardar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Override
    public void removeBarco(Barco barco) throws BussinesException {
        try {
            barcoDao.borrar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Override
    public void modifyBarco(Barco barco) throws BussinesException {
        try {
            Barco barcoBD = barcoDao.obtenerPorPK(barco);
            if(barcoBD.getCapacidadTransporte() != barco.getCapacidadTransporte()){
                if (!arriboDao.getArriboBarcoHoy(barco.getCodigo())) {
                    throw new BussinesException("No se puede modificar la Capacidad de transporte de un Barco, si no\n" +
                    "arribo a puerto ese día.");
                }
            }
            barcoDao.guardar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Override
    public List<Barco> listBarcos() throws BussinesException {
        try {
            return barcoDao.obtenerTodos();
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
}
