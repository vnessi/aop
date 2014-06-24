package uy.edu.ort.dao;

import uy.edu.ort.model.Barco;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
public interface BarcoDao extends ObjetoDao<Barco>{
    void modificar(long id, Barco barco) throws Exception;
    
}
