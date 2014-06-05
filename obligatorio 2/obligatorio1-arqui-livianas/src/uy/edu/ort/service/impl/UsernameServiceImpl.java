
package uy.edu.ort.service.impl;

import uy.edu.ort.aop.TraceAspect;
import uy.edu.ort.service.UsernameService;

/**
 *
 * @author Bruno Montaner - Victor Nessi
 */
public class UsernameServiceImpl implements UsernameService {

    @Override
    public void setearNombreUsuario(String username) {
        TraceAspect.userName = username;
    }
    
}
