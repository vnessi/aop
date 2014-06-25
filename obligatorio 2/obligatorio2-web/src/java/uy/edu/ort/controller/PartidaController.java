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
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.PartidaService;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/partida")
public class PartidaController {

    @Autowired
    private BarcoService barcoService;
    @Autowired
    private ContenedorService contenedorService;
    @Autowired
    private PartidaService partidaService;

    @RequestMapping(value = "/listPartidas", method = RequestMethod.GET)
    public String listPartidas(Model model) {
        List<Partida> partidas = null;

        try {
            partidas = this.partidaService.generarReportePartidasMes(1);
        } catch (BussinesException ex) {
            Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", 1);
        model.addAttribute("urlGenerarReporte","/reporte/partidas.htm?mes="+ 1);
        
        model.addAttribute("partidas", partidas);
        return "listPartidas";
    }

    @RequestMapping(value = "/listPartidas", method = RequestMethod.GET,params = {"mes"})
    public String listPartidasConMes(@RequestParam("mes") int mes,Model model) {
        List<Partida> partidas = null;

        try {
            partidas = this.partidaService.generarReportePartidasMes(mes);
        } catch (BussinesException ex) {
            Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", mes);
        model.addAttribute("urlGenerarReporte","/reporte/partidas.htm?mes="+ mes);
        model.addAttribute("partidas", partidas);
        return "listPartidas";
    }
    
    @RequestMapping(value = "/listPartidas", method = RequestMethod.GET,params = {"mes","idBarco"})
    public String listPartidasConMesYBarco(@RequestParam("mes") int mes,@RequestParam("idBarco") String idBarco, Model model) {
        List<Partida> partidas = null;

        try {
            partidas = this.partidaService.generarReportePartidasMesBarco(mes, idBarco);
        } catch (BussinesException ex) {
            Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("mes", mes);
        model.addAttribute("idBarco", idBarco);
        model.addAttribute("partidas", partidas);
        return "listPartidas";
    }
    
    @RequestMapping(value = "/formPartida", method = RequestMethod.GET)
    public String partidaForm(Model model) {
        Partida b = new Partida();
        model.addAttribute(b);

        List<Barco> barcos = null;

        try {
            barcos = this.barcoService.listBarcos();
        } catch (BussinesException ex) {
            Logger.getLogger(BarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("barcos", barcos);

        List<Partida> partidas = null;

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
        
        return "formPartida";
    }

    @RequestMapping(value = "/agregarPartida", method = RequestMethod.POST)
    public String agregarPartida(@RequestParam (value ="barcoId")Long barcoId,@RequestParam (value ="contList")List<Long> contList,Partida partida, BindingResult result) {
        if (partida.getDescripcion() != null && partida.getDestino()!= null && partida.getFecha()!= null ) {
            try {
                List<Contenedor> contLst = new ArrayList<>();
                for(Long c :contList){
                    Contenedor cont = contenedorService.obtenerContenedor(c.toString());
                    contLst.add(cont);
                }
                Barco b = barcoService.obtenerBarco(barcoId.toString());
                System.out.println("DESCRIPCION===>"+partida.getDescripcion());
                System.out.println("DESTINO===>"+partida.getDestino());
                System.out.println("FECHA===============>"+partida.getFecha());
                this.partidaService.registrarPartida(b, contLst, partida.getDescripcion(), partida.getDestino(), partida.getFecha());
            } catch (BussinesException ex) {
                Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
                result.reject("", ex.getMessage());
               
                return "formPartida";
            }

            return "redirect:listPartidas.htm";
        } else {
            result.reject("", "Ningun valor puede ser vacio");
            return "formPartida";
        }
    }

}
