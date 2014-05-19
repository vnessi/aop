/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.ReporteEjecucion;

/**
 *
 * @author Bruno
 */
public interface ReporteEjecucionDao extends ObjetoDao<ReporteEjecucion>{
    
    public List<List<String>> promedioEjecucionServicio();
    
    public List<String> servicioMasRapido();
    
    public List<String> servicioMasLento();
}
