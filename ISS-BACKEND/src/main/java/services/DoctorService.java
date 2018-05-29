package services;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;
import services.interfaces.IDoctorService;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {
    private final DoctorRepository doctorRepository;
    private final BloodRepository bloodRepository;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, BloodRepository bloodRepository, UserRepository userRepository, HospitalRepository hospitalRepository, RequestRepository requestRepository) {
        this.doctorRepository = doctorRepository;
        this.bloodRepository = bloodRepository;
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(Doctor updatedDonor) {
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public User findUser(Long id) {
        return null;
    }

    @Override
    public User getUserDoctor(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Hospital getHospitalDoctor(Long id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public List<Blood> getAllBlood() {
        return null;
    }

    @Override
    public void requestBlood(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<Request> getAllRequestsByDoctor(Doctor doctor) {
        return requestRepository.findAllByDoctorOrderByRequestDate(doctor);
    }
}
