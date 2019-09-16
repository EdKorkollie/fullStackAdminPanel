package Service;

import Repository.UserRePository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRePository userRePository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRePository.save(user);
    }

    //save can be used for update and insert operation in Database
    @Override
    public User updateUser(User user) {
        return userRePository.save(user);
    }

    @Override
    public void  deletUser(Long userId) {
        userRePository.deleteById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRePository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRePository.findAll();
    }

    @Override
    public Long numberOfUser() {
        return userRePository.count();
    }
}
