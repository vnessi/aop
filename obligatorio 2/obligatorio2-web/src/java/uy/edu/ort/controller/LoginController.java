/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uy.edu.ort.aop.TraceAspect;
import uy.edu.ort.util.TraceAuxiliarClass;

/**
 *
 * @author victor
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String login(Model model) {
        TraceAuxiliarClass t = new TraceAuxiliarClass();
        model.addAttribute("trace", t);
        return "login";
    }
    
    @RequestMapping(value = "/setear", method = RequestMethod.POST)
    public String login(@RequestParam("nombre") String nombre) {
        TraceAspect.userName = nombre;
        return "redirect:../barco/listBarcos.htm";
    }
}
