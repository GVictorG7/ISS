package repositories;

import model.Doctor;
import model.Request;
import model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request save(Request save);

    List<Request> findAll();

    Request findById(Long id);

    List<Request> findAllByDoctorOrderByRequestDate(Doctor doctor);

    @Query("SELECT COUNT(u) FROM Request u WHERE u.status='OPEN'")
    int findAllByStatusOpne();

    @Query("select r from Request r where r.status='OPEN' OR r.status='IN_PROGRESS'")
    List<Request> findAllNotDone();
}
