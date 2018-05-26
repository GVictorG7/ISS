package services.interfaces;

import model.Hospital;
import model.Medic;

import java.util.List;

public interface IHospitalService {
    void save(Hospital hospital);

    Hospital getById(Long id);

    void addMedic(Hospital hospital, Medic medic);

    List<Hospital> getAllHospital();

}
