package repositories;

import model.Doctor;
import model.Request;
import model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request save(Request save);

    List<Request> findAll();

    Request findById(Long id);

    List<Request> findAllByDoctorOrderByRequestDate(Doctor doctor);

    List<Request> findAllByStatus(RequestStatus status);


}
