package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Partida;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones de Partida
 */
public interface PartidaService {
    
    public void addPartida(Partida partida) throws BussinesException;

    public void removePartida(Partida partida) throws BussinesException;
    
    public Partida obtenerPartida(String codigo) throws BussinesException;
    
    public void modifyPartida(Partida partida) throws BussinesException;    

    public List<Partida> listPartidas() throws BussinesException;
}
