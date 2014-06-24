/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ContenedorService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/contenedor")
public class ContenedorController {
    
    @Autowired
    private ContenedorService contenedorService;

    @RequestMapping(value = "/listContenedores", method = RequestMethod.GET)
    public String listContenedors(Model model) {
        List<Contenedor> contenedors = null;
        
         try {
             contenedors = this.contenedorService.listContenedores();
         } catch (BussinesException ex) {
             Logger.getLogger(ContenedorController.class.getName()).log(Level.SEVERE, null, ex);
         }
        model.addAttribute("contenedores", contenedors);
        return "listContenedores";
    }
    
    @RequestMapping(value = "/formContenedor", method = RequestMethod.GET)
    public String contenedorForm(Model model) {
        Contenedor b = new Contenedor();
        model.addAttribute(b);
        return "formContenedor";
    }
    
    @RequestMapping(value = "/agregarContenedor", method = RequestMethod.POST)
    public String agregarContenedor(Contenedor contenedor, BindingResult result) {
        if (!contenedor.getCodigo().equals("") && !contenedor.getMarca().equals("") && !contenedor.getModelo().equals("")) {
            try {
                this.contenedorService.addContenedor(contenedor);
            } catch (BussinesException ex) {
                Logger.getLogger(ContenedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "redirect:listContenedores.htm";
        } else {
            result.reject("", "Hay un error en los campos ingresados");
            return "formContenedor";
        }
    }
    
    @RequestMapping(value = "/editarContenedor-{contenedorId}", method = RequestMethod.GET)
    public String editar(@PathVariable("contenedorId") Long contenedorId, Model model) {
        Contenedor contenedor=null;
        try {
            contenedor = this.contenedorService.obtenerContenedor(contenedorId.toString());
        } catch (BussinesException ex) {
            Logger.getLogger(ContenedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute(contenedor);
        //va a una vista
        return "editContenedor";
    }

    @RequestMapping(value = "/modificarContenedor", method = RequestMethod.POST)
    public String modificar(Contenedor contenedor, BindingResult result) {
        try {
            //modificar usuario
            contenedorService.modifyContenedor(contenedor);
        } catch (BussinesException ex) {
            Logger.getLogger(ContenedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:listContenedores.htm";
    }
    
    
}
