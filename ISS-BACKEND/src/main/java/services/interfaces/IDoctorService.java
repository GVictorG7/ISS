package services.interfaces;

import model.Blood;
import model.Doctor;
import model.Hospital;
import model.User;

import java.util.List;

public interface IMedicService {
    void save(Doctor doctor);

    void update(Doctor updatedDoctor);

    Doctor getById(Long id);

    User findUser(Long id);

    Hospital getHospitalMedic(Long id);

    List<Blood> getAllBlood();

    User getUserMedic(Long userId);
}
