package repositories;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    User findById(Long id);

    User save(User user);

    @Query(value = "select username from Users",nativeQuery = true)
    List<String> getUsernames();
}
