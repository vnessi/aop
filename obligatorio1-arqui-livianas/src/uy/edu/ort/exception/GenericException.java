package uy.edu.ort.exception;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import uy.edu.ort.propiedades.ManejoPropiedades;
import uy.edu.ort.util.LogUtil;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi
 * @author Bruno Montanter - Victor Nessi Bruno Montaner
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
