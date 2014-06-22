package uy.edu.ort.exception;

import java.util.logging.Level;
import uy.edu.ort.util.LogUtil;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Excepcion generica que guarda en un log el stacktrace
 */
public class GenericException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    /**
     *
     * @param message mensaje de la Excepcion
     */
    public GenericException(String message) {
        super(message);
        LogUtil.getLogFile().log(Level.SEVERE, message, this);
    }
}
