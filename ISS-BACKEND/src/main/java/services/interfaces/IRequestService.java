package services.interfaces;

import model.*;

import java.util.List;

public interface IRequestService {
    Request save(Request request);

    Request getById(Long id);

    List<Request> getAllRequest();

    List<Request> getAllRequestsByStatus(RequestStatus status);

    List<Request> getAllRequestsByDoctor(Doctor doctor);

    Doctor getDoctor(Long id);

    void deleteBlood(Long id);

    List<Blood> getAll();

    Blood findDesireBlood(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory);

    Blood saveSeparatedBlood(Blood blood, BloodCategory bloodCategory);

    List<Donor> getCopatibleDonors(BloodType bloodType, BloodRH bloodRh);
}
