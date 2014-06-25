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
import uy.edu.ort.model.Trace;
import uy.edu.ort.service.TraceService;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/rest/trace")
public class RestTraceController {
    
    @Autowired
    private TraceService traceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Trace> getTrace() {
        List<Trace> traces = traceService.listar();
        return traces;
    }

}
