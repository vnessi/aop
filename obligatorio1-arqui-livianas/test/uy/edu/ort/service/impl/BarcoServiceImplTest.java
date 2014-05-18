/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BarcoService;

/**
 *
 * @author Bruno
 */
public class BarcoServiceImplTest {

    public static BarcoService instance;
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        instance = (BarcoService) ctx.getBean("barcoService");
    }
    
    private Barco getBarco(){
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
     * Test of addBarco method, of class BarcoServiceImpl.
     */
    @Test
    public void testAddRemoveBarco() throws Exception {
        System.out.println("addBarco");
        int barcosBeforeCount = instance.listBarcos().size();
        Barco b = getBarco();
        instance.addBarco(b);
        assertEquals(b.getBandera(), "MEXICO");
        assertEquals(barcosBeforeCount+1, instance.listBarcos().size());
       
        instance.removeBarco(b.getCodigo());
        assertEquals(barcosBeforeCount, instance.listBarcos().size());
    }
/**
     * Test of addBarco method, of class BarcoServiceImpl.
     */
    @Test
    public void testModifyBarco() throws Exception {
        System.out.println("modifyBarco");
        String bandera;
        Barco barco0 = instance.listBarcos().get(0);
        bandera = barco0.getBandera();
        barco0.setBandera(bandera+" Test");
        instance.modifyBarco(barco0);
        Barco barco0Modi = instance.listBarcos().get(0);
        assertEquals(barco0Modi.getBandera(),bandera+" Test");
    }
    
     @Test
    public void testObtenerBarco() throws Exception {
        System.out.println("ObtenerBarco");
        Barco b = getBarco();
        b.setCodigo("UNCODE");
        instance.addBarco(b);
        Barco barco0 = instance.obtenerBarco(b.getCodigo());
        assertEquals(barco0.getId(), b.getId());
                
        
    }
     
}