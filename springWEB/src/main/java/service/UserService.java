package service;

import entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    void save(User user);
    User getById(int id);
    void delete(int id);
    void update(User user);
}
