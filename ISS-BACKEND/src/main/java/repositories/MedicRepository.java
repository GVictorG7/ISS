package repositories;

import model.Medic;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    Medic getByUser(User user);

    Medic save(Medic medic);

    Medic getById(Long id);

    void deleteById(Long id);
}
