/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/arribo")
public class ArriboController {

    @Autowired
    private ArriboService arriboService;

    @Autowired
    private BarcoService barcoService;

    @Autowired
    private ContenedorService contenedorService;

    @RequestMapping(value = "/listArribos", method = RequestMethod.GET)
    public String listArribos(Model model) {
        List<Arribo> arribos = null;

        try {
            arribos = this.arriboService.generarReporteArribosMes(2);
        } catch (BussinesException ex) {
            Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("arribos", arribos);
        return "listArribos";
    }

    @RequestMapping(value = "/formArribo", method = RequestMethod.GET)
    public String arriboForm(Model model) {
        Arribo b = new Arribo();
        model.addAttribute(b);

        List<Barco> barcos = null;

        try {
            barcos = this.barcoService.listBarcos();
        } catch (BussinesException ex) {
            Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("barcos", barcos);

        List<Arribo> arribos = null;

        List<Contenedor> contenedors = null;
        
         try {
             contenedors = this.contenedorService.listContenedores();
         } catch (BussinesException ex) {
             Logger.getLogger(ContenedorController.class.getName()).log(Level.SEVERE, null, ex);
         }
        model.addAttribute("contenedores", contenedors);
        
        
	Map<Contenedor,String> contenedor = new LinkedHashMap<>();
        for(Contenedor c : contenedors){
            contenedor.put(c,c.getCodigo());
        }
	model.addAttribute("contenedorList", contenedor);
        
	Map<Barco,String> barco = new LinkedHashMap<>();
        for(Barco c : barcos){
            barco.put(c,c.getCodigo());
        }
	model.addAttribute("barcoList", barco);
        
        
        

        return "formArribo";
    }

    @RequestMapping(value = "/agregarArribo", method = RequestMethod.POST)
    public String agregarArribo(Arribo arribo, BindingResult result) {
        if (true) {
            try {
                //Barco b = barcoService.obtenerBarco(arribo.getBarco().getId().toString());
                List<Contenedor> contLst = new ArrayList<>();
                for(Contenedor c :(List<Contenedor>)arribo.getContenedores()){
                    System.out.println("=========="+c);
                    
                    
                    
                    
                    
                    Contenedor cont = c;
                    contLst.add(cont);
                }
                this.arriboService.registrarArribo(arribo.getBarco(), contLst, arribo.getDescripcion(), arribo.getOrigen(), arribo.getFecha());
            } catch (BussinesException ex) {
                Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
            }

            //return "redirect:list.htm";
            return "viewArribo";
        } else {
            result.reject("", "El code no puede ser vacio");
            return "formArribo";
        }
    }

}
