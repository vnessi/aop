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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.edu.ort.model.Partida;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.PartidaService;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/rest/partida")
public class RestPartidaController {
    
    @Autowired
    private PartidaService partidaService;

    @RequestMapping(value = "/partidas", method = RequestMethod.GET, params = { "mes" })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Partida> getPartidas(@RequestParam("mes") int mes) {
        try {
            List<Partida> partidas = partidaService.generarReportePartidasMes(mes);
            return partidas;
        } catch (BussinesException ex) {
            Logger.getLogger(RestPartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/partidas", method = RequestMethod.GET, params = { "mes", "idBarco" })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Partida> getPartidas(@RequestParam("mes") int mes, @RequestParam("idBarco") String idBarco) {
        List<Partida> partidas = null;
        try {
            partidas = partidaService.generarReportePartidasMesBarco(mes, idBarco);
        } catch (BussinesException ex) {
            Logger.getLogger(RestPartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partidas;
    }
}
