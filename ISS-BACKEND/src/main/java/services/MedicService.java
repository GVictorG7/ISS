package services;

import model.Blood;
import model.Hospital;
import model.Medic;
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
    public void save(Medic medic) {
        medicRepository.save(medic);
    }

    @Override
    public void update(Medic updatedDonor) {
    }

    @Override
    public Medic getById(Long id) {
        return medicRepository.getById(id);
    }

    @Override
    public User getUserMedic(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Hospital getHospitalMedic(Long id) {
        return hospitalRepository.getById(id);
    }

    @Override
    public List<Blood> getAllBlood() {
        return null;
    }
}
