package repositories;

import model.Disease;
import model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease,Long> {
    Disease getById(Long id);
    Disease save(Disease disease);


}
