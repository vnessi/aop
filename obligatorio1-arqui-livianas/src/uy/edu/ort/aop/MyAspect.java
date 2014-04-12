package uy.edu.ort.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void metodoAspecto() {
        System.out.println("metodo del aspecto MyAspect");
        //logica negocio aspecto
    }

    public void metodoRetVal(Object retVal) {
        System.out.println("metodo aspecto retVal [" + retVal + "].");
    }

    public void metodoAround(ProceedingJoinPoint pjp) {
        try {
            pjp.proceed();
            
            System.out.println("around =>"+pjp.getSignature().getName());            
            
            
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
