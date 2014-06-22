/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.dao;

import java.util.Date;
import java.util.List;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones sobre el objeto Partida
 */
public interface PartidaDao extends ObjetoDao<Partida> {
    
    public List<Contenedor> getContenedoresDePartidasFecha(Date d) throws DaoException;
    
    public List<Partida> getPartidasEnMes(int mes) throws DaoException;
    
    public List<Partida> getPartidasEnMes(int mes, String codigoBarco) throws DaoException;
    
    public Boolean getPartidasBarcoHoy(long idBarco) throws DaoException;
}
