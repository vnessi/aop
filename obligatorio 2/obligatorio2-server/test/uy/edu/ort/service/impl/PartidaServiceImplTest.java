package uy.edu.ort.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.PartidaService;

/**
 *
 * @author victor
 */
public class PartidaServiceImplTest {

    public static BarcoService barcoService;
    public static PartidaService instance;
    public static ArriboService arriboService;

    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        instance = (PartidaService) ctx.getBean("partidaService");
        barcoService = (BarcoService) ctx.getBean("barcoService");
        arriboService = (ArriboService) ctx.getBean("arriboService");
    }

    @After
    public void tearDown() {
    }

    private Barco getBarco() {
        Barco b = new Barco();
        b.setAnioFabricacion(1990);
        b.setBandera("MEXICO");
        b.setCantidadTripulantes(22);
        b.setCapacidadTransporte(1000);
        b.setCodigo("CODE 123");
        b.setNombre("NOMBER TEST");
        b.setVersion(Long.MIN_VALUE);
        return b;
    }
    
    @Test
    public void testRegistrarPartida() throws Exception {
        System.out.println("RegistrarPartida");
        
        Barco b = getBarco();
        barcoService.addBarco(b);
        
        String descripcion = "Test Desc";
        String destino = "CHINA";

        List<Contenedor> contLst = new ArrayList<>();
        Contenedor c = new Contenedor();
        c.setCapacidad(33);
        c.setCodigo("CODE cont");
        c.setMarca("Marca");
        c.setModelo("nice");

        contLst.add(c);
        
        arriboService.registrarArribo(b, contLst, descripcion, destino, new Date());
        
        //Barco bb = barcoService.obtenerBarco("CODE 123");
        //No deberia fallar
        
        instance.registrarPartida(b, contLst, descripcion, destino, new Date());
        
        Barco b2 = getBarco();
        b2.setCodigo("CODE 000");
        barcoService.addBarco(b2);
        //Deberia fallar, ya que el mismo contendor esta partiendo el mismo dia en otro barco
        instance.registrarPartida(b2, contLst, descripcion, destino, new Date());
    }

}
