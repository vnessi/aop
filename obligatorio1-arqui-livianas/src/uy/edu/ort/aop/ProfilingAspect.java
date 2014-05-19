package uy.edu.ort.aop;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import uy.edu.ort.dao.ReporteEjecucionDao;
import uy.edu.ort.exception.GenericException;
import uy.edu.ort.model.ReporteEjecucion;

/**
 * @author Bruno Montanter - Victor Nessi
 * 
 * Aspecto encargado de calcular el tiempo de ejecucion de las operaciones
 */
public class ProfilingAspect {

     public ReporteEjecucionDao reporteEjecucionDAO;
    
    public void setReporteEjecucionDao(ReporteEjecucionDao r){
        this.reporteEjecucionDAO = r;
    }
    
    public Object profile(ProceedingJoinPoint pjp) {
        Object object = null;
        long initial = System.nanoTime();
        try {

            object = pjp.proceed();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        long fin = System.nanoTime();
        long time = fin - initial;
        System.out.println("[time " + time + "]");
        ReporteEjecucion reporte = new ReporteEjecucion();
        reporte.setServicio(pjp.getSignature().toString());
        reporte.setTiempo(time);
         try {
             reporteEjecucionDAO.guardar(reporte);
         } catch (GenericException ex) {
             Logger.getLogger(ProfilingAspect.class.getName()).log(Level.SEVERE, null, ex);
         }
        return object;
    }
}
