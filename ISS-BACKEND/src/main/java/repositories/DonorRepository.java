package repositories;

import model.Donor;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor,Long> {

    Donor getByUser(User user);
    Donor save(Donor donor);
    Donor getById(Long id);

}
