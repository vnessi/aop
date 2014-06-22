package uy.edu.ort.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.ArriboDao;
import uy.edu.ort.dao.DaoException;
import uy.edu.ort.dao.PartidaDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.PartidaService;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion de las operaciones de Partida para exponer por RMI
 */
public class PartidaServiceImpl implements PartidaService {
    
    public PartidaDao partidaDAO;
    public ArriboDao arriboDAO;
    
    public void setPartidaDao(PartidaDao p){
        this.partidaDAO = p;
    }
    
    public void setArriboDao(ArriboDao a){
        this.arriboDAO = a;
    }

    @Transactional
    @Override
    public void registrarPartida(Barco b, List<Contenedor> contLst, String descripcion, String destino, Date fecha) throws BussinesException {
        int pesoContenedores = 0;

        //Un Contenedor no puede partir en diferentes barcos el mismo día.
        List<Contenedor> contInDB = null;
        try {
            contInDB = partidaDAO.getContenedoresDePartidasFecha(fecha);
        } catch (DaoException ex) {
            Logger.getLogger(PartidaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
        for (Contenedor c_db : contInDB) {
            for (Contenedor c : contLst) {
                if (c_db.getCodigo().equals(c.getCodigo())) {
                    throw new BussinesException("Un Contenedor no puede partir en diferentes barcos el mismo día.");
                }
            }
        }
        try {
            //Un barco no puede partir, si no tiene un arribo anterior al puerto
            if(!arriboDAO.tieneArriboBarco(b.getId())) {
                throw new BussinesException("Un barco no puede partir, si no tiene un arribo anterior al puerto");
            }
        } catch (DaoException ex) {
            Logger.getLogger(PartidaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }

        Partida p = new Partida();
        p.setBarco(b);
        p.setContenedores(contLst);
        p.setFecha(fecha);
        p.setDestino(destino);
        p.setDescripcion(descripcion);

        try {
            partidaDAO.guardar(p);
        } catch (GenericException ex) {
            Logger.getLogger(PartidaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al guardar en la Base de Datos");
        }
    }

    @Transactional
    @Override
    public List<Partida> generarReportePartidasMes(int mes) throws BussinesException {
        try {
            return partidaDAO.getPartidasEnMes(mes);
        } catch (DaoException ex) {
            Logger.getLogger(PartidaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }

    @Transactional
    @Override
    public List<Partida> generarReportePartidasMesBarco(int mes, String codigoBarco) throws BussinesException {
        try {
            return partidaDAO.getPartidasEnMes(mes, codigoBarco);
        } catch (DaoException ex) {
            Logger.getLogger(PartidaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    
    
}
