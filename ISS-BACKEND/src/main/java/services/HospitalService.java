package services;

import model.Doctor;
import model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.HospitalRepository;
import services.interfaces.IHospitalService;

import java.util.List;

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
        return hospitalRepository.findById(id);
    }

    @Override
    public void addDoctor(Hospital hospital, Doctor doctor) {
        hospital.addMedic(doctor);
    }

    @Override
    public List<Hospital> getAllHospital() {

        return hospitalRepository.findAll();
    }

}