package uy.edu.ort.aop;

import org.aspectj.lang.JoinPoint;

public class TraceAspect {
    
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TraceAspect.class.getName());
    public static String userName = "defaultUser";
    public void trace(JoinPoint joinPoint) {
        logger.info("usuario: "+ userName +" [ejecuto metodo " + joinPoint.getSignature() +"]");
    }
}
