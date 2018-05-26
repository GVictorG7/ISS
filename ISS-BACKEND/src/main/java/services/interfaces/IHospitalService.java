package services.interfaces;

import model.Hospital;
import model.Medic;

public interface IHospitalService {
    void save(Hospital hospital);

    Hospital getById(Long id);

    void addMedic(Hospital hospital, Medic medic);
}
