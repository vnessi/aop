
package uy.edu.ort.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion de los servicios de Arribo para exponer por RMI
 */
public class ArriboServiceImpl implements ArriboService {

    public ArriboDao arriboDAO;
    
    public void setArriboDao(ArriboDao a){
        this.arriboDAO = a;
    }
    @Transactional
    @Override
    public void registrarArribo(Barco b, List<Contenedor> contLst, String descripcion, String origen, Date fechaArribo) throws BussinesException {
        int pesoContenedores = 0;

        //Un Barco no puede arribar si transporta un cantidad mayor que su capacidad de transporte.
        for (Contenedor c : contLst) {
            pesoContenedores += c.getCapacidad();
        }
        if (pesoContenedores > b.getCapacidadTransporte()) {
            throw new BussinesException("Un Barco no puede arribar si transporta un cantidad mayor que su capacidad de transporte.");
        }

        //Un Contenedor no puede arribar en diferentes barcos el mismo día.
        List<Contenedor> contInDB = null;
        try {
            contInDB = arriboDAO.getContenedoresDeArribosFecha(fechaArribo);
        } catch (DaoException ex) {
            Logger.getLogger(ArriboServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
        for (Contenedor c_db : contInDB) {
            for (Contenedor c : contLst) {
                if (c_db.getCodigo().equals(c.getCodigo())) {
                    throw new BussinesException("Un Contenedor no puede arribar en diferentes barcos el mismo día.");
                }
            }
        }

        Arribo a = new Arribo();
        a.setBarco(b);
        a.setContenedores(contLst);
        a.setFecha(fechaArribo);
        a.setOrigen(origen);
        a.setDescripcion(descripcion);

        try {
            arriboDAO.guardar(a);
        } catch (GenericException ex) {
            Logger.getLogger(ArriboServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al guardar en la Base de Datos");
        }

    }
    @Transactional
    @Override
    public List<Arribo> generarReporteArribosMes(int mes) throws BussinesException {
        try {
            return arriboDAO.getArribosEnMes(mes);
        } catch (DaoException ex) {
            Logger.getLogger(ArriboServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }


    }
    @Transactional
    @Override
    public List<Arribo> generarReporteArribosMesBarco(int mes, String idBarco) throws BussinesException {

        try {
            return arriboDAO.getArribosEnMes(mes, idBarco);
        } catch (DaoException ex) {
            Logger.getLogger(ArriboServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }

    }
}
