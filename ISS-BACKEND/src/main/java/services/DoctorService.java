package services;

import model.Blood;
import model.Doctor;
import model.Hospital;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import repositories.HospitalRepository;
import repositories.MedicRepository;
import repositories.UserRepository;
import services.interfaces.IMedicService;

import java.util.List;

@Service
public class MedicService implements IMedicService {
    private final MedicRepository medicRepository;
    private final BloodRepository bloodRepository;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public MedicService(MedicRepository medicRepository, BloodRepository bloodRepository, UserRepository userRepository, HospitalRepository hospitalRepository) {
        this.medicRepository = medicRepository;
        this.bloodRepository = bloodRepository;
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void save(Doctor doctor) {
        medicRepository.save(doctor);
    }

    @Override
    public void update(Doctor updatedDonor) {
    }

    @Override
    public Doctor getById(Long id) {
        return medicRepository.findById(id);
    }

    @Override
    public User findUser(Long id) {
        return null;
    }

    @Override
    public User getUserMedic(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Hospital getHospitalMedic(Long id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public List<Blood> getAllBlood() {
        return null;
    }
}
