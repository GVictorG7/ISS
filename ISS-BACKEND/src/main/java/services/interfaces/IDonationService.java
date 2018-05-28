package services.interfaces;

import model.Blood;
import model.Donation;
import model.Donor;
import model.HealthIssue;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IDonationService {
    Donation getById(Long id);
    List<Donation> findAll();
    void save(Long idDonor, LocalDate collectionDate, String forPerson, Long idBlood, Set<HealthIssue> healthIssues);
    Donation deleteById(Long id);
}
