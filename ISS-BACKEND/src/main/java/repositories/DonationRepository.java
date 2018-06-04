package repositories;

import model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {
    Donation findById(Long id);
    List<Donation> findAll();

    Donation save(Donation donation);

    Donation deleteById(Long id);

    List<Donation> getAllByDonor(Donor donor);

    @Query("SELECT COUNT(donation) FROM Donation donation WHERE donation.status='OPEN'")
    int findAllByStatusOpne();

    List<Donation> getAllByStatus(DonationStatus donationStatus);
    List<Donation> getAllByBloodTypeAndBloodRH(BloodType bloodType, BloodRH bloodRh);
}