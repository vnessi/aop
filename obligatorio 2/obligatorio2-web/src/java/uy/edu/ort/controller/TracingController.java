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
import uy.edu.ort.model.Trace;
import uy.edu.ort.service.TraceService;

/**
 *
 * @author bruno
 */
@Controller
@RequestMapping(value = "/tracing")
public class TracingController {

    @Autowired
    private TraceService tracingService;

    @RequestMapping(value = "/listTracing", method = RequestMethod.GET)
    public String listTracing(Model model) {

        List<Trace> traces = this.tracingService.listar();
        model.addAttribute("traces", traces);
        return "listTracing";
    }

}
