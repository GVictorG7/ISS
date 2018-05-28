package services;

import model.Blood;
import model.BloodCategory;
import model.BloodRH;
import model.BloodType;

import java.util.List;

public interface IBloodService {
    Blood save(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, Boolean used);
    void delete(Long id);
    List<Blood> getAll();
    Blood findById(Long id);
}
