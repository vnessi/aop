/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uy.edu.ort.service.ProfilingService;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/profiling")
public class ProfilingController {

    @Autowired
    private ProfilingService profilingService;

    @RequestMapping(value = "/listProfiling", method = RequestMethod.GET)
    public String listProfilings(Model model) {

        List<List<String>> promedios = this.profilingService.promedioEjecucionServicio();

        List<String> masLento = this.profilingService.servicioMasLento();

        List<String> masRapido = this.profilingService.servicioMasRapido();

        model.addAttribute("promedios", promedios);
        model.addAttribute("masLento", masLento);
        model.addAttribute("masRapido", masRapido);
        return "listProfiling";
    }

}
