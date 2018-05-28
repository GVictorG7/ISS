package services;

import model.Blood;
import model.Donation;
import model.Donor;
import model.HealthIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import repositories.DonationRepository;
import repositories.DonorRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class DonationService implements IDonationService{
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;
    private final BloodRepository bloodRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodRepository bloodRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodRepository = bloodRepository;
    }

    @Override
    public Donation getById(Long id) {
        return donationRepository.getById(id);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public void save(Long idDonor, LocalDate collectionDate, String forPerson, Long idBlood, Set<HealthIssue> healthIssues) {
        donationRepository.save(new Donation(
                donorRepository.getById(idDonor),
                collectionDate,
                forPerson,
                bloodRepository.getById(idBlood),
                healthIssues));
    }

    @Override
    public Donation deleteById(Long id) {
        return donationRepository.deleteById(id);
    }
}
