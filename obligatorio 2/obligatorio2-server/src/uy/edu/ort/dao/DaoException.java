
package uy.edu.ort.dao;

import uy.edu.ort.exception.GenericException;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Excepcion para las operaciones DAO
 */
public class DaoException extends GenericException {

    public DaoException(String message) {
        super(message);
    }
    
}
