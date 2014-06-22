package uy.edu.ort.service;

import java.util.Date;
import java.util.List;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones de Partida
 */
public interface PartidaService {
    
    public void registrarPartida(Barco b, List<Contenedor> contLst, String descripcion, String destino, Date fecha) throws BussinesException;

    public List<Partida> generarReportePartidasMes(int mes) throws BussinesException;

    public List<Partida> generarReportePartidasMesBarco(int mes, String codigoBarco) throws BussinesException;
}
