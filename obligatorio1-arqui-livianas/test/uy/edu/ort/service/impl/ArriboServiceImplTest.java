/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BarcoService;

/**
 *
 * @author Bruno
 */
public class ArriboServiceImplTest {

    public ArriboServiceImplTest() {
    }
    public static BarcoService barcoService;
    public static ArriboService instance;

    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        instance = (ArriboService) ctx.getBean("arriboService");
        barcoService = (BarcoService) ctx.getBean("barcoService");
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

    /**
     * Test of registrarArribo method, of class ArriboServiceImpl.
     */
    @Test
    public void testRegistrarArribo() throws Exception {
        System.out.println("registrarArribo");
        Barco b = getBarco();
        barcoService.addBarco(b);
        String descripcion = "Test Desc";
        String origen = "CHINA";

        List<Contenedor> contLst = new ArrayList<>();
        Contenedor c = new Contenedor();
        c.setCapacidad(33);
        c.setCodigo("CODE cont");
        c.setMarca("Marca");
        c.setModelo("nice");

        contLst.add(c);
        instance.registrarArribo(b, contLst, descripcion, origen);
        
    }

    /**
     * Test of generarReporteArribosMes method, of class ArriboServiceImpl.
     */
    @Test
    public void testGenerarReporteArribosMes() throws Exception {
      System.out.println("generarReporteArribosMes");
        int mes = 5;
        List<Arribo> arribos = instance.generarReporteArribosMes(mes);
        assertEquals(arribos.size(), 12);
    }

    /**
     * Test of generarReporteArribosMesBarco method, of class ArriboServiceImpl.
     */
    @Test
    public void testGenerarReporteArribosMesBarco() throws Exception {
        System.out.println("generarReporteArribosMesBarco");
        int mes = 4;
        String codigoBarco = "";
        List<Arribo> arribos = instance.generarReporteArribosMesBarco(mes, "123");
        assertEquals(arribos.size(), 0);
    }
}