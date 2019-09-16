package Service;

import model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    //save can be used for update and insert operation in Database
    User updateUser(User user);

    void  deletUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUser();
}
