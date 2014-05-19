/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.model.Contenedor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones de Contenedor
 */
public interface ContenedorService {
    
    public void addContenedor(Contenedor contenedor) throws BussinesException;

    public void removeContenedor(Contenedor contenedor) throws BussinesException;
    
    public Contenedor obtenerContenedor(String codigo) throws BussinesException;
    
    public void modifyContenedor(Contenedor contenedor) throws BussinesException;    

    public List<Contenedor> listContenedors() throws BussinesException;
}
