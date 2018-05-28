package services.interfaces;

import model.*;

import java.util.List;

public interface IDoctorService {
    void save(Doctor doctor);

    void update(Doctor updatedDoctor);

    Doctor getById(Long id);

    User findUser(Long id);

    Hospital getHospitalDoctor(Long id);

    List<Blood> getAllBlood();

    User getUserDoctor(Long userId);

    void requestBlood(Request request);

    List<Request> getAllRequest();
}
