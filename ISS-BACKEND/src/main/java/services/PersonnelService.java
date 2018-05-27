package services;

import model.Donation;
import model.Personnel;
import model.Request;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonationRepository;
import repositories.PersonnelRepository;
import repositories.RequestRepository;
import repositories.UserRepository;
import services.interfaces.IPersonelService;

import java.util.List;


@Service
public class PersonelService implements IPersonelService {
    private final UserRepository userRepository;
    private final PersonnelRepository personnelRepository;
    private final RequestRepository requestRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public PersonelService(UserRepository userRepository, PersonnelRepository personnelRepository, RequestRepository requestRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.requestRepository = requestRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public Personnel save(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    @Override
    public List<Donation> getAllDonation() {
        return donationRepository.findAll();
    }

    @Override
    public List<Request> getAllBloodRequest() {
        return requestRepository.findAll();
    }
    @Override
    public User getUserPersonel(Long id) {
        return userRepository.findById(id);
    }

}
