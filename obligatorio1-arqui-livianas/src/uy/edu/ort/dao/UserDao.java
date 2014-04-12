package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.User;

public interface UserDao {

    public void addUser(User user);

    public void removeUser(User user);

    public List<User> listUsers();
}
