/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uy.edu.ort.beanWiring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Category;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Bean Post Processor para interceptar e imprimir en consola los Beans creados
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    
    static final Category log = Category.getInstance(MyBeanPostProcessor.class);
    static final String LOG_PROPERTIES_FILE = "Configuracion/Propiedades.properties";
    
    @Override
    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String string) throws BeansException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //LogUtil.getLogFile().info(dateFormat.format(date) + " ::::::::: Nombre Bean: " + string + " ::::::::: Clase: "+ o.getClass().getName());
        log.info(dateFormat.format(date) + " ::::::::: Nombre Bean: " + string + " ::::::::: Clase: "+ o.getClass().getName());
        return o;
    }
    
}
