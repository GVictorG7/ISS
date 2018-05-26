package repositories;

import model.Medic;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    Medic findByUser(User user);

    Medic save(Medic medic);

    Medic findById(Long id);

    void deleteById(Long id);
}
