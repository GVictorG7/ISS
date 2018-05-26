package repositories;

import model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital save(Hospital hospital);

    Hospital findById(Long id);
}
