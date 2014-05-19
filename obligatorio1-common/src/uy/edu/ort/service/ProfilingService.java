/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.service;

import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ProfilingService {
    
    public List<List<String>> promedioEjecucionServicio();
    
    public List<String> servicioMasRapido();
    
    public List<String> servicioMasLento();
    
    
    
}
