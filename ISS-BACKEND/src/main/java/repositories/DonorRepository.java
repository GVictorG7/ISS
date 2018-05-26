package repositories;

import model.Donor;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    Donor findByUser(User user);

    Donor save(Donor donor);

    Donor findById(Long id);

}
