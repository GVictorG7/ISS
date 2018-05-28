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
import services.interfaces.IDonationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class DonationService implements IDonationService {
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;


    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodRepository bloodRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;

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
    public void save(Long idDonor, LocalDate collectionDate, String forPerson,  Set<HealthIssue> healthIssues) {
        donationRepository.save(new Donation(
                donorRepository.findById(idDonor),
                collectionDate,
                forPerson,
                healthIssues));
    }

    @Override
    public Donation deleteById(Long id) {
        return donationRepository.deleteById(id);
    }
}
