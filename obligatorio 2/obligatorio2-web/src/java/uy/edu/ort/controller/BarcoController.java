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
import org.springframework.web.bind.annotation.RequestParam;
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/barco")
public class BarcoController {
    
    @Autowired
    private BarcoService barcoService;

    @RequestMapping(value = "/listBarcos", method = RequestMethod.GET)
    public String listBarcos(Model model) {
        List<Barco> barcos = null;
        
         try {
             barcos = this.barcoService.listBarcos();
         } catch (BussinesException ex) {
             Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
         }
        model.addAttribute("barcos", barcos);
        return "listBarcos";
    }
    
    @RequestMapping(value = "/formBarco", method = RequestMethod.GET)
    public String barcoForm(Model model) {
        Barco b = new Barco();
        model.addAttribute(b);
        return "formBarco";
    }
    
    @RequestMapping(value = "/agregarBarco", method = RequestMethod.POST)
    public String agregarBarco(Barco barco, BindingResult result) {
        if (!barco.getCodigo().equals("") && !barco.getNombre().equals("") && !barco.getBandera().equals("")) {
            try {
                this.barcoService.addBarco(barco);
            } catch (BussinesException ex) {
                Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "redirect:listBarcos.htm";
        } else {
            result.reject("", "Hay un error en los campos ingresados");
            return "formBarco";
        }
    }
    
    @RequestMapping(value = "/editarBarco-{barcoId}", method = RequestMethod.GET)
    public String editar(@PathVariable("barcoId") Long barcoId, Model model) {
        Barco barco=null;
        try {
            barco = this.barcoService.obtenerBarco(barcoId.toString());
        } catch (BussinesException ex) {
            Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute(barco);
        //va a una vista
        return "editBarco";
    }

    @RequestMapping(value = "/modificarBarco", method = RequestMethod.POST)
    public String modificar(@RequestParam("id") long id, Barco barco, BindingResult result) {
        try {
            barcoService.modifyBarco(id, barco);
        } catch (BussinesException ex) {
            Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:listBarcos.htm";
    }
    
    @RequestMapping(value = "/eliminarBarco-{barcoId}", method = RequestMethod.GET)
    public String eliminar(@PathVariable("barcoId") Long barcoId, Model model) {
        try {
           Barco barco = barcoService.obtenerBarco(barcoId.toString());
           this.barcoService.removeBarco(barco);
        } catch (BussinesException ex) {
            Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return "redirect:listBarcos.htm";
    }
    
    
}
