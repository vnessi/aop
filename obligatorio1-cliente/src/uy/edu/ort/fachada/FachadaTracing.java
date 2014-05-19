package uy.edu.ort.fachada;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.service.UsernameService;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Fachada con las operaciones de tracing
 * En esta implementacion solamente tenemos la operacion para setear el nombre del usuario
 */
public class FachadaTracing {
    private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
    private static final UsernameService usernameService = (UsernameService) ctx.getBean("usernameService");
    
    public static void setearUsername(String username){
        usernameService.setearNombreUsuario(username);
    }
}
