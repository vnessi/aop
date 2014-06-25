/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.restServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uy.edu.ort.service.ProfilingService;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/rest/profiling")
public class RestProfilingController {
    
    @Autowired
    private ProfilingService profilingService;

    @RequestMapping(value = "/rapido", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> getMasRapido() {
        List<String> rapido = profilingService.servicioMasRapido();
        return rapido;
    }
    
    @RequestMapping(value = "/lento", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<String> getMasLento() {
        List<String> lento = profilingService.servicioMasLento();
        return lento;
    }
    
    @RequestMapping(value = "/promedios", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<List<String>> getpromedios() {
        List<List<String>> promedios = profilingService.promedioEjecucionServicio();
        return promedios;
    }

}
