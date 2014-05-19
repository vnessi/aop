/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.fachada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.pdf.PdfUtil;
import uy.edu.ort.service.ArriboService;
import uy.edu.ort.service.BarcoService;
import uy.edu.ort.service.BussinesException;
import uy.edu.ort.service.ContenedorService;

/**
 *
 * @author Bruno Montanter - Victor Nessi victor
 */
public class FachadaArribo {

    private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/application-context.xml");
    private static final ArriboService arriboDao = (ArriboService) ctx.getBean("arriboService");
    private static final ContenedorService contenedorDao = (ContenedorService) ctx.getBean("contenedorService");
    private static final BarcoService barcoDao = (BarcoService) ctx.getBean("barcoService");

    public static void registrarArribos(String datosArribo, String contenedores) {
        try {
            String[] argsDatos = datosArribo.split(",");
            String[] argsContenedores = contenedores.split(",");

            Date fechaArribo = obtenerFechaDesdeString(argsDatos[1]);
            Barco b = barcoDao.obtenerBarco(argsDatos[3]);

            List<Contenedor> listaContenedores = new ArrayList<>();
            for (String codContenedor : argsContenedores) {
                Contenedor c = contenedorDao.obtenerContenedor(codContenedor);
                listaContenedores.add(c);

            }
            arriboDao.registrarArribo(b, listaContenedores, argsDatos[2], argsDatos[0], fechaArribo);
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaArribo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void generarReporteArribosMes(String mes) {
        try {
            List<Arribo> arribosResultado = arriboDao.generarReporteArribosMes(Integer.valueOf(mes));
            System.out.println("\tId \t\tOrigen \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores");
            for (Arribo arribo : arribosResultado) {
                String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
                String codigoConts = "";
                for (Object c : arribo.getContenedores()) {
                    codigoConts += " - " + ((Contenedor)c).getCodigo();
                }
                codigoConts += " - ";
                System.out.println("\t" + arribo.getId() + "\t\t" + arribo.getOrigen() +
                    " \t\t" + fechaString + " \t\t" + arribo.getDescripcion() +
                    " \t\t" + arribo.getBarco().getCodigo() + " \t\t" + codigoConts);
                
            }
            PdfUtil.crearReportePDFMes(arribosResultado, mes);
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaArribo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void generarReporteArribosMesBarco(String mes, String codigoBarco) {
        try {
            List<Arribo> arribosResultado = arriboDao.generarReporteArribosMes(Integer.valueOf(mes));
            System.out.println("\tId \t\tOrigen \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores \t\tPeso Total");
            for (Arribo arribo : arribosResultado) {
                String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
                String codigoConts = "";
                int peso = 0;
                for (Object c : arribo.getContenedores()) {
                    codigoConts += " - " + ((Contenedor)c).getCodigo();
                    peso += ((Contenedor) c).getCapacidad();
                }
                codigoConts += " - ";
                System.out.println("\t" + arribo.getId() + "\t\t" + arribo.getOrigen() +
                    " \t\t" + fechaString + " \t\t" + arribo.getDescripcion() +
                    " \t\t" + arribo.getBarco().getCodigo() + " \t\t" + codigoConts + " \t\t" + peso);
                        
                
            }
            PdfUtil.crearReportePDFMesBarco(arribosResultado, mes, codigoBarco);
        } catch (BussinesException ex) {
            Logger.getLogger(FachadaArribo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Date obtenerFechaDesdeString(String dateInString) {
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fecha = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
}
