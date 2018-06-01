package services.interfaces;

import model.Blood;
import model.Doctor;
import model.Request;

import java.util.List;

public interface IRequestService {
    Request save(Request request);

    Request getById(Long id);

    List<Request> getAllRequest();

    List<Request> getAllRequestsByStatus(String status);

    List<Request> getAllRequestsByDoctor(Doctor doctor);

    Doctor getDoctor(Long id);

    void saveSeparatedBlood(Long idBlood);
}
