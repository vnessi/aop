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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author victor
 */
@Controller
@RequestMapping(value = "/rest/arribo")
public class RestArriboController {
    
    @Autowired
    private ArriboService arriboService;

    @RequestMapping(value = "/arribos", method = RequestMethod.GET, params = { "mes" })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Arribo> getArribos(@RequestParam("mes") int mes) {
        try {
            List<Arribo> arribos = arriboService.generarReporteArribosMes(mes);
            return arribos;
        } catch (BussinesException ex) {
            Logger.getLogger(RestArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/arribos", method = RequestMethod.GET, params = { "mes", "idBarco" })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Arribo> getArribos(@RequestParam("mes") int mes, @RequestParam("idBarco") String idBarco) {
        List<Arribo> arribos = null;
        try {
            arribos = arriboService.generarReporteArribosMesBarco(mes, idBarco);
        } catch (BussinesException ex) {
            Logger.getLogger(RestArriboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arribos;
    }
    
}
