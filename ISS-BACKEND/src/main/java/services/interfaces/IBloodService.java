package services.interfaces;

import model.Blood;
import model.BloodCategory;
import model.BloodRH;
import model.BloodType;

import java.time.LocalDate;
import java.util.List;

public interface IBloodService {
    Blood save(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, Boolean used, LocalDate expireDate);

    void delete(Long id);

    List<Blood> getAll();

    Blood findById(Long id);
}
