package services;

import model.Blood;
import model.BloodCategory;
import model.Doctor;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.BloodRepository;
import repositories.DoctorRepository;
import repositories.RequestRepository;
import services.interfaces.IRequestService;

import java.util.List;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;
    private final DoctorRepository doctorRepository;
    private final BloodRepository bloodRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, DoctorRepository doctorRepository, BloodRepository bloodRepository) {
        this.requestRepository = requestRepository;
        this.doctorRepository = doctorRepository;
        this.bloodRepository = bloodRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request getById(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestsByStatus(String status) {
        return requestRepository.findAllByStatus(status);
    }

    @Override
    public List<Request> getAllRequestsByDoctor(Doctor doctor) {
        return requestRepository.findAllByDoctorOrderByRequestDate(doctor);
    }

    // used in controller
    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void saveSeparatedBlood(Long idBlood) {
        Blood blood = bloodRepository.getById(idBlood);
        if(blood.getBloodCategory().equals(BloodCategory.WHOLE)) {

            Blood bloodWithRedCellCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.REDCELL, blood.getUsed());
            Blood bloodWithThrombocyteCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.THROMBOCYTE, blood.getUsed());
            Blood bloodWithPlasmaCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.PLASMA, blood.getUsed());

            bloodRepository.save(bloodWithRedCellCategory);
            bloodRepository.save(bloodWithThrombocyteCategory);
            bloodRepository.save(bloodWithPlasmaCategory);

            bloodRepository.delete(blood);
        }
    }


}
