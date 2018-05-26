package services;

import model.Donation;
import model.Donor;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonationRepository;
import repositories.DonorRepository;
import repositories.UserRepository;
import services.interfaces.IDonorService;

import java.util.List;

@Service
public class DonorService implements IDonorService {
    private final DonorRepository donorRepository;
    private final UserRepository userRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public DonorService(DonorRepository donorRepository, UserRepository userRepository, DonationRepository donationRepository) {
        this.donorRepository = donorRepository;
        this.userRepository = userRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public void save(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public void update(Donor updateDonor) {
    }

    @Override
    public Donor getById(Long id) {
        return donorRepository.findById(id);
    }

    @Override
    public User getUserDonor(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Donation> getAllDonation(Donor donor) {
        return donationRepository.findAllByDonor(donor);
    }
}
