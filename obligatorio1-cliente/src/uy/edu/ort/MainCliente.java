/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author victor
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context.xml");
            
//        UserService userService = (BarcoService) applicationContext.getBean("userService");
//        List<Barco> users = userService.listUsers();
//        if (users != null) {
//            for (User user : users) {
//                System.out.println(user);
//            }
//        }

//        User u = new User("pp", "Piter");
//        userService.addUser(u);
//        
//        users = userService.listUsers("Peter");
//        if (users != null) {
//            for (User user : users) {
//                System.out.println(user);
//            }
//        }
            
            BarcoService barcoDao = (BarcoService) applicationContext.getBean("barcoService");
            Barco b = new Barco();
            b.setAnioFabricacion(1990);
            b.setBandera("si tiene");
            b.setCantidadTripulantes(22);
            b.setCapacidadTransporte(1000);
            b.setCodigo("no code");
            b.setNombre("name barc");
            barcoDao.addBarco(b);
        } catch (BussinesException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
