package services;

import model.*;
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
    private final BloodRepository bloodRepository;


    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodRepository bloodRepository, BloodRepository bloodRepository1) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodRepository = bloodRepository1;
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
    public void save(Long idDonor, LocalDate collectionDate, String forPerson, DonationStatus status, BloodRH bloodRH,BloodType bloodType, Set<HealthIssue> healthIssues) {
        donationRepository.save(new Donation(
                donorRepository.findById(idDonor),
                collectionDate,
                forPerson,
                status,
                bloodRH,
                bloodType,
                healthIssues));
    }
    @Override
    public Donation save(Long idDonor) {
        return donationRepository.save(new Donation(donorRepository.findById(idDonor)));
    }

    @Override
    public Donation deleteById(Long id) {
        return donationRepository.deleteById(id);
    }

    @Override
    public void changeStatus(Donation donation) {
        if (donation.getStatus() == DonationStatus.ACCEPTED) {
                bloodRepository.save(new Blood(donation.getBloodType(),donation.getBloodRH(),BloodCategory.WHOLE,false));

        }

    }
}
