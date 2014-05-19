package uy.edu.ort.aop;

import org.aspectj.lang.JoinPoint;

public class TraceAspect {

    public void trace(JoinPoint joinPoint) {
        System.out.println("[metodo interceptado " + joinPoint.getSignature().getName() +"]");

    }
}
