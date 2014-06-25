package uy.edu.ort.aop;

import uy.edu.ort.model.Trace;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import uy.edu.ort.dao.TraceDao;

/**
 * @author Bruno Montanter - Victor Nessi
 *
 * Clase encargada de logear las operaciones ejecutadas por el cliente
 */
public class TraceAspect {

    public TraceDao traceDao;

    public void setTraceDao(TraceDao t) {
        this.traceDao = t;
    }

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TraceAspect.class.getName());
    public static String userName = "defaultUser";

    public void trace(JoinPoint joinPoint) throws Throwable {

        Trace t = new Trace();
        t.setFecha(new Date());
        t.setDescripcion("usuario: " + userName + " [ejecuto metodo " + joinPoint.getSignature() + "]");
        try {
            traceDao.guardar(t);
        } catch (Exception ex) {
            throw ex;
        }
        logger.info("usuario: " + userName + " [ejecuto metodo " + joinPoint.getSignature() + "]");

    }
}
