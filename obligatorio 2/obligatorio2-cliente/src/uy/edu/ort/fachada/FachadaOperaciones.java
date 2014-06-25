/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.fachada;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Barco;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.model.Partida;
import uy.edu.ort.model.Trace;
import uy.edu.ort.propiedades.ManejoPropiedades;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class FachadaOperaciones {
    
    @Autowired
    private static RestTemplate restTemplate;
    
    
    /*
     * Operaiones sobre la Entidad Contenedor
     */
    
    public static void mostrarContenedor(String codigo) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restcontenedor/" + codigo + ".htm";
        
        Contenedor c = restTemplate.getForObject(url, Contenedor.class);
            System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
            System.out.println("\t" + String.valueOf(c.getId()) + "\t\t" + c.getCodigo() 
                    + " \t\t" + c.getMarca()+ " \t\t" + c.getModelo()  
                    + " \t\t" + String.valueOf(c.getCapacidad()));
            
    }
    
    public static void listarContenedores() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restcontenedor/contenedores.htm";
        
        Contenedor[] contenedores = restTemplate.getForObject(url, Contenedor[].class);
        System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
        for (Contenedor c : contenedores) {
            System.out.println("\t" + c.getId() + "\t\t" + c.getCodigo() +
                " \t\t" + c.getMarca()+ " \t\t" + c.getModelo() +
                    "\t\t" + String.valueOf(c.getCapacidad()));
        }
    }
    
    /**
     * Operaciones sobre la Entidad Barco
     */
    
    public static void mostrarBarco(String codigo) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restbarco/" + codigo + ".htm";
        
        Barco barco = restTemplate.getForObject(url, Barco.class);
        System.out.println("\tId \t\tCodigo \t\tNombre \t\tBandera \t\tCapacidad(kgs) \t\tAño \t\tCantidadTripulantes");
        System.out.println("\t" + barco.getId() + "\t\t" + barco.getCodigo()
                + " \t\t" + barco.getNombre() + " \t\t" + barco.getBandera()
                + " \t\t" + barco.getCapacidadTransporte() + " \t\t" + String.valueOf(barco.getAnioFabricacion())
                + " \t\t" + barco.getCantidadTripulantes());
        
    }

    public static void listarBarcos() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restbarco/barcos.htm";
        
        Barco[] barcos = restTemplate.getForObject(url, Barco[].class);
        System.out.println("\tId \t\tCodigo \t\tNombre \t\tBandera \t\tCapacidad(kgs) \t\tAño \t\tCantidadTripulantes");
        for (Barco barco : barcos) {
            System.out.println("\t" + barco.getId() + "\t\t" + barco.getCodigo()
                    + " \t\t" + barco.getNombre() + " \t\t" + barco.getBandera()
                    + " \t\t" + barco.getCapacidadTransporte() + " \t\t" + String.valueOf(barco.getAnioFabricacion())
                    + " \t\t" + barco.getCantidadTripulantes());
        }
    }
    
    /**
     * Operaciones sobre la Entidad Arribo
     */
    
    public static void generarReporteArribosMes(String mes) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restarribo/arribos.htm?mes=" + mes;
        
        Arribo[] arribosResultado = restTemplate.getForObject(url, Arribo[].class);
        System.out.println("\tId \t\tOrigen \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores");
        for (Arribo arribo : arribosResultado) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
            String codigoConts = "";
            for (Object c : arribo.getContenedores()) {
                codigoConts += " - " + ((LinkedHashMap)c).get("codigo");
            }
            codigoConts += " - ";
            System.out.println("\t" + arribo.getId() + "\t\t" + arribo.getOrigen() +
                " \t\t" + fechaString + " \t\t" + arribo.getDescripcion() +
                " \t\t" + arribo.getBarco().getCodigo() + " \t\t" + codigoConts);

        }
    }
    
    public static void generarReporteArribosMesBarco(String mes, String idBarco) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restarribo/arribos.htm?mes=" + mes + "&idBarco=" + idBarco;
        
        Arribo[] arribosResultado = restTemplate.getForObject(url, Arribo[].class);
        System.out.println("\tId \t\tOrigen \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores \t\tPeso Total");
        for (Arribo arribo : arribosResultado) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
            String codigoConts = "";
            int peso = 0;
            for (Object c : arribo.getContenedores()) {
                codigoConts += " - " + ((LinkedHashMap)c).get("codigo");
                Object capacidad = ((LinkedHashMap)c).get("capacidad");
                peso += (Integer)capacidad;
            }
            codigoConts += " - ";
            System.out.println("\t" + arribo.getId() + "\t\t" + arribo.getOrigen() +
                " \t\t" + fechaString + " \t\t" + arribo.getDescripcion() +
                " \t\t" + arribo.getBarco().getCodigo() + " \t\t" + codigoConts + " \t\t" + peso);

        }
    }
    
    /**
     * Operaciones sobre la Entidad Partida
     */
    
    public static void generarReportePartidasMes(String mes) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restpartida/partidas.htm?mes=" + mes;
        
        Partida[] partidasResultado = restTemplate.getForObject(url, Partida[].class);
        System.out.println("\tId \t\tDestino \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores");
        for (Partida partida : partidasResultado) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(partida.getFecha());
            String codigoConts = "";
            for (Object c : partida.getContenedores()) {
                codigoConts += " - " + ((LinkedHashMap)c).get("codigo");
            }
            codigoConts += " - ";
            System.out.println("\t" + partida.getId() + "\t\t" + partida.getDestino()+
                " \t\t" + fechaString + " \t\t" + partida.getDescripcion() +
                " \t\t" + partida.getBarco().getCodigo() + " \t\t" + codigoConts);

        }
    }
    
    public static void generarReportePartidasMesBarco(String mes, String idBarco) {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restpartida/partidas.htm?mes=" + mes + "&idBarco=" + idBarco;
        
        Partida[] partidasResultado = restTemplate.getForObject(url, Partida[].class);
        System.out.println("\tId \t\tDestino \t\tFecha \t\tDescripcion \t\tBarco \t\tContenedores \t\tPeso Total");
        for (Partida partida : partidasResultado) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(partida.getFecha());
            String codigoConts = "";
            int peso = 0;
            for (Object c : partida.getContenedores()) {
                codigoConts += " - " + ((LinkedHashMap)c).get("codigo");
                Object capacidad = ((LinkedHashMap)c).get("capacidad");
                peso += (Integer)capacidad;
            }
            codigoConts += " - ";
            System.out.println("\t" + partida.getId() + "\t\t" + partida.getDestino() +
                " \t\t" + fechaString + " \t\t" + partida.getDescripcion() +
                " \t\t" + partida.getBarco().getCodigo() + " \t\t" + codigoConts + " \t\t" + peso);


        }
    }
    
    public static void listarTrazas() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "resttrace/all.htm";
        Trace[] trazas= null;
        try {   
            trazas = restTemplate.getForObject(url, Trace[].class);
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
        }
        
        
        System.out.println("\tFecha \t\tDescripcion");
        for (Trace t : trazas) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(t.getFecha());
            System.out.println("\t" + fechaString + "\t\t" + t.getDescripcion());
        }
    }
}
