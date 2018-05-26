package services.interfaces;

import model.Blood;
import model.Hospital;
import model.Medic;
import model.User;

import java.util.List;

public interface IMedicService {
    void save(Medic medic);

    void update(Medic updatedMedic);

    Medic getById(Long id);

    User getUserMedic(Long id);

    Hospital getHospitalMedic(Long id);

    List<Blood> getAllBlood();
}
