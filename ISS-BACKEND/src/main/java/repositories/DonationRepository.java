package repositories;

import model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {
    Donation findById(Long id);
    List<Donation> findAll();

    Donation save(Donation donation);

    Donation deleteById(Long id);

    List<Donation> getAllByDonor(Donor donor);

    List<Donation> getAllByStatus(DonationStatus donationStatus);
    List<Donation> getAllByBloodTypeAndBloodRH(BloodType bloodType, BloodRH bloodRh);
}