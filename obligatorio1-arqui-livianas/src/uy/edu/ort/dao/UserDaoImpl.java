package uy.edu.ort.dao;

import java.util.List;
import uy.edu.ort.model.User;

public class UserDaoImpl implements UserDao {

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.users.remove(user);
    }

    @Override
    public List<User> listUsers() {
        return this.users;
    }
}
