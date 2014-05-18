package uy.edu.ort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUserService {

    public static void main(String[] args) {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
//
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
    }
}
