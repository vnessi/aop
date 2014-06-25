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
import org.springframework.web.bind.annotation.RequestParam;
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
            arribos = this.arriboService.generarReporteArribosMes(1);
        } catch (BussinesException ex) {
            Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", 1);
        model.addAttribute("arribos", arribos);
        return "listArribos";
    }

    @RequestMapping(value = "/listArribos", method = RequestMethod.GET,params = {"mes"})
    public String listArribosConMes(@RequestParam("mes") int mes,Model model) {
        List<Arribo> arribos = null;

        try {
            arribos = this.arriboService.generarReporteArribosMes(mes);
        } catch (BussinesException ex) {
            Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", mes);
        model.addAttribute("arribos", arribos);
        return "listArribos";
    }
    
    @RequestMapping(value = "/listArribos", method = RequestMethod.GET,params = {"mes","idBarco"})
    public String listArribosConMesYBarco(@RequestParam("mes") int mes,@RequestParam("idBarco") String idBarco, Model model) {
        List<Arribo> arribos = null;

        try {
            arribos = this.arriboService.generarReporteArribosMesBarco(mes, idBarco);
        } catch (BussinesException ex) {
            Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", mes);
        model.addAttribute("idBarco", idBarco);
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
        
        
	Map<Long,String> contenedor = new LinkedHashMap<>();
        for(Contenedor c : contenedors){
            contenedor.put(c.getId(),c.getCodigo());
        }
	model.addAttribute("contenedorList", contenedor);
        
	Map<Long,String> barco = new LinkedHashMap<>();
        for(Barco barc : barcos){
            barco.put(barc.getId(),barc.getCodigo());
        }
	model.addAttribute("barcoList", barco);
        
        return "formArribo";
    }

    @RequestMapping(value = "/agregarArribo", method = RequestMethod.POST)
    public String agregarArribo(@RequestParam (value ="barcoId")Long barcoId,@RequestParam (value ="contList")List<Long> contList,Arribo arribo, BindingResult result) {
        if (arribo.getDescripcion() != null && arribo.getOrigen()!= null && arribo.getFecha()!= null ) {
            try {
                List<Contenedor> contLst = new ArrayList<>();
                for(Long c :contList){
                    Contenedor cont = contenedorService.obtenerContenedor(c.toString());
                    contLst.add(cont);
                }
                Barco b = barcoService.obtenerBarco(barcoId.toString());
                this.arriboService.registrarArribo(b, contLst, arribo.getDescripcion(), arribo.getOrigen(), arribo.getFecha());
            } catch (BussinesException ex) {
                Logger.getLogger(ArriboController.class.getName()).log(Level.SEVERE, null, ex);
                result.reject("", ex.getMessage());
               
                return "formArribo";
            }

            return "redirect:listArribos.htm";
        } else {
            result.reject("", "Ningun valor puede ser vacio");
            return "formArribo";
        }
    }

}
