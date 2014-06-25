package uy.edu.ort.controller;

import java.io.OutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Partida;
import uy.edu.ort.pdf.PdfUtil;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.PartidaService;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Controller
@RequestMapping(value = "/reporte")
public class ReporteController {
    
    @Autowired
    ArriboService arriboService;
    
    @Autowired
    PartidaService partidaService;
    
    @RequestMapping(value = "/arribos", method = RequestMethod.GET, produces = "application/pdf", params = { "mes" })
    public void arribos(@RequestParam("mes") int mes, OutputStream response) {
        try {
            List<Arribo> arribos = arriboService.generarReporteArribosMes(mes);
            PdfUtil.crearReporteArribosPDFMes(arribos, String.valueOf(mes), response);
        } catch (Exception ex) {
        }
    }
    
    @RequestMapping(value = "/arribos", method = RequestMethod.GET, produces = "application/pdf", params = { "mes", "idBarco" })
    public void arribos(@RequestParam("mes") int mes, @RequestParam("idBarco") String idBarco, OutputStream response) {
        try {
            List<Arribo> arribos = arriboService.generarReporteArribosMesBarco(mes, idBarco);
            PdfUtil.crearReporteArribosPDFMesBarco(arribos, String.valueOf(mes), idBarco, response);
        } catch (Exception ex) {
        }
    }
    
    @RequestMapping(value = "/partidas", method = RequestMethod.GET, produces = "application/pdf", params = { "mes" })
    public void partidas(@RequestParam("mes") int mes, OutputStream response) {
        try {
            List<Partida> partidas = partidaService.generarReportePartidasMes(mes);
            PdfUtil.crearReportePartidasPDFMes(partidas, String.valueOf(mes), response);
        } catch (Exception ex) {
        }
    }
    
    @RequestMapping(value = "/partidas", method = RequestMethod.GET, produces = "application/pdf", params = { "mes", "idBarco" })
    public void partidas(@RequestParam("mes") int mes, @RequestParam("idBarco") String idBarco, OutputStream response) {
        try {
            List<Partida> partidas = partidaService.generarReportePartidasMesBarco(mes, idBarco);
            PdfUtil.crearReportePartidasPDFMesBarco(partidas, String.valueOf(mes), idBarco, response);
        } catch (Exception ex) {
        }
    }
    
}
