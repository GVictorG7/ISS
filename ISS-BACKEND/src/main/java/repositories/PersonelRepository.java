package repositories;

import model.Medic;
import model.Personel;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel, Long> {
    Personel save(Personel personel);
    Personel findByUser(User user);
}
