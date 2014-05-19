
package uy.edu.ort.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.propiedades.ManejoPropiedades;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi - Bruno Montaner
 */
public class LogUtil {
    
    private static Logger LOGGER = null;
    
    public static Logger getLogFile() {
        if(LOGGER == null) {
            try {
                LOGGER = Logger.getLogger("");
                FileHandler fhandler = new FileHandler(ManejoPropiedades.obtenerInstancia().obtenerPropiedad("Log"));
                SimpleFormatter sformatter = new SimpleFormatter();
                fhandler.setFormatter(sformatter);
                LOGGER.addHandler(fhandler);
            } catch (IOException ex) {
                Logger.getLogger(GenericException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return LOGGER;
    }
}
