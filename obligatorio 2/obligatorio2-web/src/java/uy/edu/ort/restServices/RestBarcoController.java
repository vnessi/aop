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
import uy.edu.ort.model.Barco;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/rest/barco")
public class RestBarcoController {
    
    @Autowired
    private BarcoService barcoService;

    @RequestMapping(value = "/{idBarco}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Barco getBarco(@PathVariable("idBarco") long id) {
        try {
            Barco barco = barcoService.obtenerBarco(String.valueOf(id));
            return barco;
        } catch (BussinesException ex) {
            Logger.getLogger(RestBarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/barcos", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Barco> getBarcos() {
        List<Barco> barcos = null;
        try {
            barcos = barcoService.listBarcos();
        } catch (BussinesException ex) {
            Logger.getLogger(RestBarcoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barcos;
    }
}
