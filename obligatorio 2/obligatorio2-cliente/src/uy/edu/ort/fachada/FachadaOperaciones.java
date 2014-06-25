/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.fachada;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Contenedor c = restTemplate1.getForObject(url, Contenedor.class);
            System.out.println("\tId \t\tCodigo \t\tMarca \t\tModelo \t\tCapacidad(kgs)");
            System.out.println("\t" + String.valueOf(c.getId()) + "\t\t" + c.getCodigo() 
                    + " \t\t" + c.getMarca()+ " \t\t" + c.getModelo()  
                    + " \t\t" + String.valueOf(c.getCapacidad()));
            
    }
    
    public static void listarContenedores() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restcontenedor/contenedores.htm";
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        
        Contenedor[] contenedores = restTemplate1.getForObject(url, Contenedor[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Barco barco = restTemplate1.getForObject(url, Barco.class);
        System.out.println("\tId \t\tCodigo \t\tNombre \t\tBandera \t\tCapacidad(kgs) \t\tAño \t\tCantidadTripulantes");
        System.out.println("\t" + barco.getId() + "\t\t" + barco.getCodigo()
                + " \t\t" + barco.getNombre() + " \t\t" + barco.getBandera()
                + " \t\t" + barco.getCapacidadTransporte() + " \t\t" + String.valueOf(barco.getAnioFabricacion())
                + " \t\t" + barco.getCantidadTripulantes());
        
    }

    public static void listarBarcos() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restbarco/barcos.htm";
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        
        Barco[] barcos = restTemplate1.getForObject(url, Barco[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Arribo[] arribosResultado = restTemplate1.getForObject(url, Arribo[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Arribo[] arribosResultado = restTemplate1.getForObject(url, Arribo[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        
        Partida[] partidasResultado = restTemplate1.getForObject(url, Partida[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        
        Partida[] partidasResultado = restTemplate1.getForObject(url, Partida[].class);
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
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        Trace[] trazas= null;
        try {   
            trazas = restTemplate1.getForObject(url, Trace[].class);
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
        }
        
        
        System.out.println("\tFecha \t\tDescripcion");
        for (Trace t : trazas) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(t.getFecha());
            System.out.println("\t" + fechaString + "\t\t" + t.getDescripcion());
        }
    }
    
    public static void profilingMasLento() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restprofiling/lento.htm";
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        String[] lento = restTemplate1.getForObject(url, String[].class);
        
        System.out.println("\tOperacion \t\tTiempo");
        System.out.println("\t" + lento[0] + "\t\t" + lento[1]);
        
    }
    
    public static void profilingMasRapido() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restprofiling/rapido.htm";
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        String[] rapido = restTemplate1.getForObject(url, String[].class);
        
        System.out.println("\tOperacion \t\tTiempo");
        System.out.println("\t" + rapido[0] + "\t\t" + rapido[1]);
        
    }
    
    public static void profilingPromedios() {
        String url = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("restService") + "restprofiling/promedios.htm";
        
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate1.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        
        String promedios = restTemplate1.getForObject(url, String.class);
        System.out.println("\tOperacion \t\tTiempo");
        String[] ss = promedios.split("]");
        for(int i=0; i<ss.length; i++) {
            
            System.out.println("\t" + ss[i].replace("[", ""));
        }
        
        
        
    }
}
