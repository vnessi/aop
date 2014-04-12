package uy.edu.ort.service;

import java.util.List;
import uy.edu.ort.dao.UserDao;
import uy.edu.ort.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        System.out.println("addUser " + user.getName());
        this.userDao.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        System.out.println("removeUser " + user.getName());
        this.userDao.removeUser(user);
    }

    @Override
    public List<User> listUsers() {
        System.out.println("listUsers ");
        return this.userDao.listUsers();        
    }
}
