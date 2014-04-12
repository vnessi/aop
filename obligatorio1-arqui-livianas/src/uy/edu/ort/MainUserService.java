package uy.edu.ort;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.ort.model.User;
import uy.edu.ort.service.UserService;

public class MainUserService {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/application-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
