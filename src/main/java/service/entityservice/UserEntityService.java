package service.entityservice;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User save(User category) {
        return userRepository.save(category);
    }

}
