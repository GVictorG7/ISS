package repositories;

import model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    Treatment getById(Long id);

    Treatment save(Treatment treatment);
}
