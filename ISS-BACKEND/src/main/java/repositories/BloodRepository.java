package repositories;

import model.Blood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRepository extends JpaRepository<Blood,Long> {
    Blood getById(Long id);
    List<Blood> findAll();
    Blood save(Blood blood);
    Blood deleteById(Long id);
}
