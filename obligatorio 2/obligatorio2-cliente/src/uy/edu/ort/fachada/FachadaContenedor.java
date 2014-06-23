package uy.edu.ort.fachada;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.propiedades.ManejoPropiedades;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Fachada con las operaciones relacionada con el objeto Contenedor
 */
public class FachadaContenedor {
    
    @Autowired
    private static ContenedorService contenedorDao;
    
    public static void agregarContenedor(String argumentos) {
        try {
            
            String[] args = argumentos.split(",");
            
            Contenedor c = new Contenedor();
            c.setCodigo(args[0]);
            c.setMarca(args[1]);
            c.setModelo(args[2]);
            c.setCapacidad(Integer.valueOf(args[3]));
            contenedorDao.addContenedor(c);
            System.out.println(">> Contenedor agregado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void eliminarContenedor(String codigo) {
        try {
            Contenedor c = contenedorDao.obtenerContenedor(codigo);
            contenedorDao.removeContenedor(c);
            System.out.println(">> Contenedor eliminado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void modificarContenedor(String codigo, String argumentos) {
        try {
            Contenedor c = contenedorDao.obtenerContenedor(codigo);
            
            String[] args = argumentos.split(",");
            
            c.setCodigo(args[0]);
            c.setMarca(args[1]);
            c.setModelo(args[2]);
            c.setCapacidad(Integer.valueOf(args[3]));
            contenedorDao.modifyContenedor(c);
            System.out.println(">> Contenedor modificado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void mostrarContenedor(String codigo) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restcontenedor/" + codigo + ".htm";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        Contenedor c = restTemplate.getForObject(url, Contenedor.class);
            System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
            System.out.println("\t" + String.valueOf(c.getId()) + "\t\t" + c.getCodigo() 
                    + " \t\t" + c.getMarca()+ " \t\t" + c.getModelo()  
                    + " \t\t" + String.valueOf(c.getCapacidad()));
            
    }
    
    public static void listarContenedores() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restcontenedor/contenedores.htm";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        Contenedor[] contenedores = restTemplate.getForObject(url, Contenedor[].class);
        System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
        for (Contenedor c : contenedores) {
            System.out.println("\t" + c.getId() + "\t\t" + c.getCodigo() +
                " \t\t" + c.getMarca()+ " \t\t" + c.getModelo() +
                    "\t\t" + String.valueOf(c.getCapacidad()));
        }
    }
}
