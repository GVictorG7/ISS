package services;

import model.Doctor;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DoctorRepository;
import repositories.RequestRepository;
import services.interfaces.IRequestService;

import java.util.List;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, DoctorRepository doctorRepository) {
        this.requestRepository = requestRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
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
}
