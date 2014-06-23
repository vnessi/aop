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
import uy.edu.ort.model.Partida;
import uy.edu.ort.service.PartidaService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/partida")
public class PartidaController {
    
    @Autowired
    private PartidaService partidaService;

    @RequestMapping(value = "/listPartidas", method = RequestMethod.GET)
    public String listPartidas(Model model) {
        List<Partida> partidas = null;
        
         try {
             partidas = this.partidaService.generarReportePartidasMes(2);
         } catch (BussinesException ex) {
             Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
         }
        model.addAttribute("partidas", partidas);
        return "listPartidas";
    }
    
    @RequestMapping(value = "/formPartida", method = RequestMethod.GET)
    public String partidaForm(Model model) {
        Partida b = new Partida();
        model.addAttribute(b);
        return "formPartida";
    }
    
    @RequestMapping(value = "/agregarPartida", method = RequestMethod.POST)
    public String agregarPartida(Partida partida, BindingResult result) {
        if (!partida.getId().equals("")) {
            try {
                this.partidaService.registrarPartida(null, null, null, null, null);
            } catch (BussinesException ex) {
                Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //return "redirect:list.htm";
            return "viewPartida";
        } else {
            result.reject("", "El code no puede ser vacio");
            return "formPartida";
        }
    }
    
}
