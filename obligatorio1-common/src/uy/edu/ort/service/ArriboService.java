/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno
 */
public interface ArriboService {

    public void registrarArribo(Barco b, List<Contenedor> contLst, String descripcion, String origen) throws BussinesException;

    public List<Arribo> generarReporteArribosMes(int mes) throws BussinesException;

    public List<Arribo> generarReporteArribosMesBarco(int mes, String codigoBarco) throws BussinesException;
}
