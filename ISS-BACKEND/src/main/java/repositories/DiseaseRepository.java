package repositories;

import model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    Disease getById(Long id);

    Disease save(Disease disease);
}
