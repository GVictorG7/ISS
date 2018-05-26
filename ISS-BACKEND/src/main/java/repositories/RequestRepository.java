package repositories;

import model.Medic;
import model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request save(Request save);

    List<Request> findAll();

    List<Request> findAllById(Long id);

    List<Request> findAllByMedic(Medic medic);
}