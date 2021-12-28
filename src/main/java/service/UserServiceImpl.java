package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.entityservice.UserEntityService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityService userEntityService;
    @Override
    public List<User> findAll() {
        List<User> userList=userEntityService.findAll();
        return userList;
    }

    @Override
    public User findById(String id) {
        User userById = userEntityService.findById(id);
        return userById;
    }

    @Override
    public User save(User user) {
        return userEntityService.save(user);
    }

    @Override
    public void delete(String id) {
        userEntityService.deleteById(id);
    }
}
