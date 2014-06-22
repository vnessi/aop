
package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.ReporteEjecucion;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Interface con las operaciones Reportes
 */
public interface ReporteEjecucionDao extends ObjetoDao<ReporteEjecucion>{
    
    public List<List<String>> promedioEjecucionServicio();
    
    public List<String> servicioMasRapido();
    
    public List<String> servicioMasLento();
}
