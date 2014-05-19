/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.dao.ContenedorDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Bruno Montanter - Victor Nessi Bruno
 */
public class ContenedorServiceImpl implements ContenedorService{
 
    ContenedorDao contenedorDao;

    public void setContenedorDao(ContenedorDao c) {
        this.contenedorDao = c;
    }
    @Transactional
    @Override
    public void addContenedor(Contenedor contenedor) throws BussinesException {
        try {
            contenedorDao.guardar(contenedor);
        } catch (GenericException ex) {
            Logger.getLogger(ContenedorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    @Transactional
    @Override
    public void removeContenedor(Contenedor contenedor) throws BussinesException {
        try {
            contenedorDao.borrar(contenedor);
        } catch (GenericException ex) {
            Logger.getLogger(ContenedorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    @Transactional 
    @Override
    public void modifyContenedor(Contenedor contenedor) throws BussinesException {
        try {
            contenedorDao.modificar(contenedor);
        } catch (GenericException ex) {
            Logger.getLogger(ContenedorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    @Transactional
    @Override
    public List<Contenedor> listContenedors() throws BussinesException {
        try {
            return contenedorDao.obtenerTodos();
        } catch (GenericException ex) {
            Logger.getLogger(ContenedorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    
    @Transactional
    @Override
    public Contenedor obtenerContenedor(String codigo) throws BussinesException {
        try {
            return contenedorDao.obtenerPorPropiedad("codigo", codigo).get(0);
        } catch (GenericException ex) {
            Logger.getLogger(ContenedorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BussinesException("Error al acceder la Base de Datos");
        }
    }
    
}
