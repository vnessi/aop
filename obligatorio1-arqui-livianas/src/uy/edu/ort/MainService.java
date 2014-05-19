package uy.edu.ort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainService {

    public static void main(String[] args) {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context.xml");

    }
}
