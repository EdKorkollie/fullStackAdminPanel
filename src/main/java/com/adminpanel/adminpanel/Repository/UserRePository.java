package Repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRePository extends JpaRepository<User, Long> {

    //findby + Username
    Optional<User> findByUsername(String username);
}
