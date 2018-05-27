package repositories;

import model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    Donor getById(Long id);
    List<Donor> findAll();
    Donor save(Donor donor);
    Donor deleteById(Long id);
}
