package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.exception.GenericException;

/**
 *
 * @param <T> 
 * @author Victor Nessi
 * @author Bruno Montaner
 * 
 */
public interface ObjetoDao <T> {
	
	/**
     *
     * @param entity
     * @throws uy.edu.ort.exception.GenericException
     */
    void guardar(T entity) throws GenericException;
	/**
     *
     * @param entity
     * @throws uy.edu.ort.exception.GenericException
     */
    void borrar(T entity) throws GenericException;
	/**
     *
     * @param id
     * @return
     * @throws uy.edu.ort.exception.GenericException
     */
    T obtenerPorPK(Object id) throws GenericException;
	/**
     *
     * @return
     * @throws uy.edu.ort.exception.GenericException
     */
    List<T> obtenerTodos() throws GenericException;
	/**
     *
     * @param prop
     * @param val
     * @return
     * @throws uy.edu.ort.exception.GenericException
     */
    List<T> obtenerPorPropiedad(String prop, Object val) throws GenericException;
}