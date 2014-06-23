package uy.edu.ort.fachada;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Fachada con las operaciones relacionada con el objeto Contenedor
 */
public class FachadaContenedor {
    private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
    private static final ContenedorService contenedorDao = (ContenedorService) ctx.getBean("contenedorService");
    
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
        try {
            Contenedor c = contenedorDao.obtenerContenedor(codigo);
            System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
            System.out.println("\t" + String.valueOf(c.getId()) + "\t\t" + c.getCodigo() 
                    + " \t\t" + c.getMarca()+ " \t\t" + c.getModelo()  
                    + " \t\t" + String.valueOf(c.getCapacidad()));
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void listarContenedores() {
        try {
            List<Contenedor> contenedores = contenedorDao.listContenedores();
             System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
            for (Contenedor c : contenedores) {
                System.out.println("\t" + c.getId() + "\t\t" + c.getCodigo() +
                    " \t\t" + c.getMarca()+ " \t\t" + c.getModelo() +
                        "\t\t" + String.valueOf(c.getCapacidad()));
            }
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
