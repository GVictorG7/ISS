package repositories;

import model.Doctor;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUser(User user);

    Doctor save(Doctor doctor);

    Doctor findById(Long id);

    void deleteById(Long id);
}
