/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Bruno Montanter - Victor Nessi Bruno
 */
public class ContenedorServiceImplTest {
    
    public static ContenedorService instance;
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        instance = (ContenedorService) ctx.getBean("contenedorService");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of addContenedor method, of class ContenedorServiceImpl.
     */
    @Test
    public void testContenedorService() throws Exception {
        System.out.println("ContenedorService");
        
        int conts = instance.listContenedors().size();
        Contenedor contenedor = new Contenedor();
        contenedor.setCapacidad(22);
        contenedor.setCodigo("testCode");
        contenedor.setMarca("GElEY");
        contenedor.setModelo("Thunder");
        instance.addContenedor(contenedor);
        
        assertEquals(conts + 1, instance.listContenedors().size());
        
        instance.removeContenedor(contenedor);
        
        assertEquals(conts, instance.listContenedors().size());
    }

}