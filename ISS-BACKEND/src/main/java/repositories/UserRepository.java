package repositories;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getByUsernameAndPassword(String username, String password);
    User getById(Long id);
    User save(User user);
}
