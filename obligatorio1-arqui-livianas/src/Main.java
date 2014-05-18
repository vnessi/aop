
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.ArriboService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viti
 */
public class Main {

    public static void main(String[] args) {
//        try {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        ArriboService aservice = (ArriboService) ctx.getBean("arriboService");

        BarcoDao barcoDao = (BarcoDao) ctx.getBean("barcoDao");
        Barco b = new Barco();
        b.setAnioFabricacion(1990);
        b.setBandera("no tiene");
        b.setCantidadTripulantes(22);
        b.setCapacidadTransporte(1000);
        b.setCodigo("no code");
        b.setNombre("name barc");
        
        
        try {
            barcoDao.guardar(b);
        } catch (GenericException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

//        aservice.registrarArribo(b, null, null, null);
//            BarcoDao bdao ;
//            System.out.print(bdao.obtenerTodos());
//        } catch (GenericException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private static void s() throws GenericException {
        throw new GenericException("<< Exception >>>>>>>>>>>>>>>>");
    }
}
