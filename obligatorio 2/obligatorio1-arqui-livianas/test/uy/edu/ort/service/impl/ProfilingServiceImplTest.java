/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.ReporteEjecucion;
import uy.edu.ort.service.ProfilingService;

/**
 *
 * @author Bruno Montanter - Victor Nessi Bruno
 */
public class ProfilingServiceImplTest {
    
    public ProfilingServiceImplTest() {
    }
    
     public static ProfilingService instance;
    
    @BeforeClass
    public static void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
        instance = (ProfilingService) ctx.getBean("profilingService");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of promedioEjecucionServicio method, of class ProfilingServiceImpl.
     */
    @Test
    public void testPromedioEjecucionServicio() {
        System.out.println("promedioEjecucionServicio");
        List expResult = null;
        List<List<String>> result = instance.promedioEjecucionServicio();
        for(List<String> r : result){
            for(String s: r){
            System.out.println("--->"+s);
            }
        }
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of servicioMasRapido method, of class ProfilingServiceImpl.
     */
    @Test
    public void testServicioMasRapido() {
        System.out.println("servicioMasRapido");
        List<String> result  = instance.servicioMasRapido();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of servicioMasLento method, of class ProfilingServiceImpl.
     */
    @Test
    public void testServicioMasLento() {
        System.out.println("servicioMasLento");
        ReporteEjecucion expResult = null;
        List<String> result = instance.servicioMasLento();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}