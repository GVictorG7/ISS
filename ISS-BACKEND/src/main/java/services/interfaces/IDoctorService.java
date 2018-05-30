package services.interfaces;

import model.Blood;
import model.Doctor;
import model.Hospital;
import model.User;

import java.util.List;

public interface IDoctorService {
    void save(Doctor doctor);

    void update(Doctor updatedDoctor);

    Doctor getById(Long id);

    User findUser(Long id);

    Hospital getHospitalDoctor(Long id);

    List<Blood> getAllBlood();

    User getUserDoctor(Long userId);
}
