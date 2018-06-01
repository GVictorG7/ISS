package services.interfaces;

import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IDonationService {
    Donation getById(Long id);

    List<Donation> findAll();

    void save(Long idDonor, LocalDate collectionDate, String forPerson, DonationStatus status, BloodRH bloodRH, BloodType bloodType, Set<HealthIssue> healthIssues);

    Donation deleteById(Long id);

    void changeStatus(Long idDonatie,String forPerson, DonationStatus status, String bloodRH, String bloodType, Set<HealthIssue> healthIssues);

    void save(Long idDonor);


    List<Donation> getAllDonationsByDonor(Long idDonor);

    void update(Donation donation);

    List<Donation> getAllOpenDonations();


}
