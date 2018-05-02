package dao;

import entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    void save(User user);
    User getById(int id);
    void delete(int id);
    void update(User user);
}
