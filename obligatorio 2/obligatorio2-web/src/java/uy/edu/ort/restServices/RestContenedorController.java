/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.restServices;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/rest")
public class RestContenedorController {
    @Autowired
    private ContenedorService contenedorService;

    @RequestMapping(value = "/contenedor/{idContenedor}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Contenedor getContenedor(@PathVariable("idContenedor") long id) {
        try {
            Contenedor contenedor = contenedorService.obtenerContenedor(String.valueOf(id));
            return contenedor;
        } catch (BussinesException ex) {
            Logger.getLogger(RestContenedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/contenedor/contenedores", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Contenedor> getContenedors() {
        List<Contenedor> contenedores = null;
        try {
            contenedores = contenedorService.listContenedores();
        } catch (BussinesException ex) {
            Logger.getLogger(RestContenedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenedores;
    }
}
