/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
