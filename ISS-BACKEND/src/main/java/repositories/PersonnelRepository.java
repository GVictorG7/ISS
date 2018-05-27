package repositories;

import model.Personnel;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Personnel save(Personnel personnel);
    Personnel findByUser(User user);
}
