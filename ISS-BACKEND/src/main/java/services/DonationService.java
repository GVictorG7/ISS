package services;

import model.Donation;
import model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonationRepository;
import services.interfaces.IDonationService;

import java.util.List;

@Service
public class DonationService implements IDonationService {
    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void update(Donation updateDonation) {
    }

    @Override
    public Donation getById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public List<Donation> findAllByDonor(Donor donor) {
        return donationRepository.findAllByDonor(donor);
    }
}
