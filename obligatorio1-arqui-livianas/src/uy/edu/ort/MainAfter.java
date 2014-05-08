package uy.edu.ort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.dao.BarcoDao;
import uy.edu.ort.dao.impl.BarcoDaoImpl;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BusinessService;

public class MainAfter {

    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context-after.xml");
        BusinessService businessService = (BusinessService) applicationContext.getBean("businessService");
        String str = businessService.serviceMethod(123);
        System.out.println(str);*/
        
        BarcoDao b = new BarcoDaoImpl();
        Barco ba = new Barco("1", "nombre", "Peru", 100, 2014, 10);
        b.agregarBarco(ba);
    }
}
