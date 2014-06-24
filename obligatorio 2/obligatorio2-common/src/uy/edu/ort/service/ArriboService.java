package uy.edu.ort.service;

import java.util.Date;
import java.util.List;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones de Arribo
 */
public interface ArriboService {

    public void registrarArribo(Barco b, List<Contenedor> contLst, String descripcion, String origen, Date fechaArribo) throws BussinesException;

    public List<Arribo> generarReporteArribosMes(int mes) throws BussinesException;

    public List<Arribo> generarReporteArribosMesBarco(int mes, String idBarco) throws BussinesException;
}
