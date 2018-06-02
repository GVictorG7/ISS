package repositories;

import model.Blood;
import model.BloodCategory;
import model.BloodRH;
import model.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BloodRepository extends JpaRepository<Blood, Long> {
    Blood getById(Long id);

    List<Blood> findAll();

    Blood save(Blood blood);

    Blood deleteById(Long id);

    @Query("select b from Blood b where b.bloodCategory=?1 and b.bloodRh=?2 and b.bloodType=?3 and b.used=false and b.expireDate>current_date")
    List<Blood> findBloodForRequest(BloodCategory bloodCategory, BloodRH bloodRh, BloodType bloodType);

    @Query("select b from Blood b where b.bloodType=?1 and b.bloodRh=?2 and b.bloodCategory='WHOLE' and b.used=false and b.expireDate>current_date")
    List<Blood> findByBloodTypeAndBloodRh(BloodType bloodType, BloodRH bloodRh);

}