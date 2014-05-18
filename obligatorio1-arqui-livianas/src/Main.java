
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;


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

        BarcoService barcoDao = (BarcoService) ctx.getBean("barcoService");
        BarcoDao barcoDaoo = (BarcoDao) ctx.getBean("barcoDao");
        Barco b = new Barco();
        b.setAnioFabricacion(1990);
        b.setBandera("no tiene lalala");
        b.setCantidadTripulantes(22);
        b.setCapacidadTransporte(1000);
        b.setCodigo("no code");
        b.setNombre("name barc");
        b.setVersion(Long.MIN_VALUE);
        try {        
        
            barcoDao.addBarco(b);
            
            System.out.println(barcoDao.listBarcos().toString());
            
            b.setBandera("URUGUAY");
            barcoDao.modifyBarco(b);
            try {
                System.out.println(barcoDaoo.obtenerPorPropiedad("bandera","URUGUAY"));
            } catch (GenericException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            List<Contenedor> conts = new ArrayList<>();
            Contenedor c = new Contenedor();
            c.setCapacidad(33);
            c.setCodigo("CODE cont");
            c.setMarca("Marca");
            c.setModelo("nice");
            
            conts.add(c);
            //aservice.registrarArribo(b, conts, "Descriptioin ", "CHINA");
            
            System.out.println(aservice.generarReporteArribosMes(5));
//        aservice.registrarArribo(b, null, null, null);
//            BarcoDao bdao ;
//            System.out.print(bdao.obtenerTodos());
//        } catch (GenericException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (BussinesException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void s() throws GenericException {
        throw new GenericException("<< Exception >>>>>>>>>>>>>>>>");
    }
}
