package uy.edu.ort.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi - Bruno Montaner
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
    
    @Transactional
    @Override
    public void addBarco(Barco barco) throws BussinesException {
        try {
            barcoDao.guardar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Transactional
    @Override
    public void removeBarco(Barco barco) throws BussinesException {
        try {
            barcoDao.borrar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Transactional
    @Override
    public void modifyBarco(Barco barco) throws BussinesException {
        try {
            Barco barcoBD = barcoDao.obtenerPorPK(barco);
            if(barcoBD != null && barcoBD.getCapacidadTransporte() != barco.getCapacidadTransporte()){
                if (!arriboDao.getArriboBarcoHoy(barco.getCodigo())) {
                    throw new BussinesException("No se puede modificar la Capacidad de transporte de un Barco, si no\n" +
                    "arribo a puerto ese día.");
                }
            }
            barcoDao.modificar(barco);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Transactional
    @Override
    public List<Barco> listBarcos() throws BussinesException {
        try {
            return barcoDao.obtenerTodos();
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    
    @Transactional
    @Override
    public Barco obtenerBarco(String codigo) throws BussinesException {
        try {
            return barcoDao.obtenerPorPropiedad("codigo", codigo).get(0);
        } catch (GenericException ex) {
            Logger.getLogger(BarcoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
}
