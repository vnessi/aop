package uy.edu.ort.fachada;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.model.Barco;
import uy.edu.ort.propiedades.ManejoPropiedades;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 *
 * Fachada para manejar las operaciones relacionadas con el objeto Barco
 */
public class FachadaBarco {

    @Autowired
    private static BarcoService barcoDao;

    public static void agregarBarco(String argumentos) {
        try {

            String[] args = argumentos.split(",");

            Barco b = new Barco();
            b.setCodigo(args[0]);
            b.setNombre(args[1]);
            b.setBandera(args[2]);
            b.setCapacidadTransporte(Integer.valueOf(args[3]));
            b.setAnioFabricacion(Integer.valueOf(args[4]));
            b.setCantidadTripulantes(Integer.valueOf(args[5]));
            barcoDao.addBarco(b);
            System.out.println(">> Barco agregado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarBarco(String codigo) {
        try {
            Barco barco = barcoDao.obtenerBarco(codigo);
            barcoDao.removeBarco(barco);
            System.out.println(">> Barco eliminado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void modificarBarco(String codigo, String argumentos) {
        try {
            Barco b = barcoDao.obtenerBarco(codigo);

            String[] args = argumentos.split(",");

            b.setCodigo(args[0]);
            b.setNombre(args[1]);
            b.setBandera(args[2]);
            b.setCapacidadTransporte(Integer.valueOf(args[3]));
            b.setAnioFabricacion(Integer.valueOf(args[4]));
            b.setCantidadTripulantes(Integer.valueOf(args[5]));
            barcoDao.modifyBarco(b);
            System.out.println(">> Barco modificado con exito");
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaBarco.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mostrarBarco(String codigo) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restbarco/" + codigo + ".htm";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        Barco barco = restTemplate.getForObject(url, Barco.class);
        System.out.println("\tId \t\tCodigo \t\tNombre \t\tBandera \t\tCapacidad(kgs) \t\tAño \t\tCantidadTripulantes");
        System.out.println("\t" + barco.getId() + "\t\t" + barco.getCodigo()
                + " \t\t" + barco.getNombre() + " \t\t" + barco.getBandera()
                + " \t\t" + barco.getCapacidadTransporte() + " \t\t" + String.valueOf(barco.getAnioFabricacion())
                + " \t\t" + barco.getCantidadTripulantes());
        
    }

    public static void listarBarcos() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restbarco/barcos.htm";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Barco[] barcos = restTemplate.getForObject(url, Barco[].class);
        System.out.println("\tId \t\tCodigo \t\tNombre \t\tBandera \t\tCapacidad(kgs) \t\tAño \t\tCantidadTripulantes");
        for (Barco barco : barcos) {
            System.out.println("\t" + barco.getId() + "\t\t" + barco.getCodigo()
                    + " \t\t" + barco.getNombre() + " \t\t" + barco.getBandera()
                    + " \t\t" + barco.getCapacidadTransporte() + " \t\t" + String.valueOf(barco.getAnioFabricacion())
                    + " \t\t" + barco.getCantidadTripulantes());
        }
    }
}
