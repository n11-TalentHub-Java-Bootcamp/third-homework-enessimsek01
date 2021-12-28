package service;

import entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);
    User save(User user);
    void delete(String id);
}
