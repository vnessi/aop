package uy.edu.ort.service.impl;

import java.util.List;
import uy.edu.ort.model.Partida;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.PartidaService;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Implementacion de las operaciones de Partida para exponer por RMI
 */
public class PartidaServiceImpl implements PartidaService{

    @Override
    public void addPartida(Partida partida) throws BussinesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePartida(Partida partida) throws BussinesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Partida obtenerPartida(String codigo) throws BussinesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyPartida(Partida partida) throws BussinesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Partida> listPartidas() throws BussinesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
