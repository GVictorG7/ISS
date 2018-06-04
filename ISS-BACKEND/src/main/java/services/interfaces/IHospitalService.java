package services.interfaces;

import model.Hospital;
import model.Doctor;

import java.util.List;

public interface IHospitalService {
    void save(Hospital hospital);

    Hospital getById(Long id);

    void addDoctor(Hospital hospital, Doctor doctor);

    List<Hospital> getAllHospital();

}
