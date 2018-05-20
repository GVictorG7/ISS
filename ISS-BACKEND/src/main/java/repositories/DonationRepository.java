package repositories;

import model.Donation;
import model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    Donation getById(Long id);
    Donation save(Donation donation);
    List<Donation> findAllByDonor(Donor donor);
    List<Donation> findAll();
    void deleteById(Long id);

}
