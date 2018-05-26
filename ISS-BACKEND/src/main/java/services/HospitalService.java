package services;

import model.Hospital;
import model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.HospitalRepository;
import services.interfaces.IHospitalService;

@Service
public class HospitalService implements IHospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getById(Long id) {
        return hospitalRepository.getById(id);
    }

    @Override
    public void addMedic(Hospital hospital, Medic medic) {
        hospital.addMedic(medic);
    }
}
