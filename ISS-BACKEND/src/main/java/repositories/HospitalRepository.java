package repositories;

import model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital save(Hospital hospital);

    Hospital findById(Long id);

    @Override
    List<Hospital> findAll();
}
