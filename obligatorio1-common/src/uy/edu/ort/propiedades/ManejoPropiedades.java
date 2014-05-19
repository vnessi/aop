package uy.edu.ort.propiedades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase encargada de manejar las propiedades del Sistema.
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi
 * @author Bruno Montanter - Victor Nessi Bruno Montaner
 */
public class ManejoPropiedades {

    private static ManejoPropiedades instancia;
    private static Properties propiedades = new Properties();

    private ManejoPropiedades() {
        cargarProperties();
    }

    /**
     * Obtengo una instancia de ManejoPropiedades
     *
     * @return
     * @throws PropiedadesPaooException  
     */
    public static ManejoPropiedades obtenerInstancia() {
        if (instancia == null) {
            try {
                instancia = new ManejoPropiedades();
            } catch (Exception ex) {
                
            }
        }
        return instancia;
    }

    /**
     * Metodo para obtener una propiedad especifica del archivo de propiedades.
     *
     * @param clave
     * @return
     */
    public String obtenerPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }

    private static void cargarProperties() {
        try {
            //se crea una instancia a la clase Properties
            propiedades = new Properties();
            //se leen el archivo .properties
            String workingDir = System.getProperty("user.dir");
            String path = workingDir + "/Configuracion/Propiedades.properties";
            propiedades.load(new FileInputStream(path));

        } catch (IOException ex) {
        }
    }
}
