package repositories;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User getById(String username);
    List<User> findAll();
    User save(User user);
    User deleteById(String username);
}
