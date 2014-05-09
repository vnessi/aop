
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.dao.impl.BarcoDaoImpl;
import uy.edu.ort.model.Barco;

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
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context-after.xml");
        BusinessService businessService = (BusinessService) applicationContext.getBean("businessService");
        String str = businessService.serviceMethod(123);
        System.out.println(str);*/
        
        BarcoDao b = new BarcoDaoImpl();
        Barco ba = new Barco("2", "nombre", "Peru", 100, 2014, 10);
        b.agregarBarco(ba);
    }
}
