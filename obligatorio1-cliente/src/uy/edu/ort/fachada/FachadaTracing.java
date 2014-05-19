/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.fachada;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.service.ContenedorService;
import uy.edu.ort.service.UsernameService;

/**
 *
 * @author viti
 */
public class FachadaTracing {
    private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
    private static final UsernameService usernameService = (UsernameService) ctx.getBean("usernameService");
    
    public static void setearUsername(String username){
        usernameService.setearNombreUsuario(username);
    }
}
