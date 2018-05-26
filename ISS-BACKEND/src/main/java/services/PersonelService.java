package services;

import model.Donation;
import model.Personel;
import model.Request;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonationRepository;
import repositories.PersonelRepository;
import repositories.RequestRepository;
import repositories.UserRepository;
import services.interfaces.IPersonelService;

import java.util.List;


@Service
public class PersonelService implements IPersonelService {
    private final UserRepository userRepository;
    private final PersonelRepository personelRepository;
    private final RequestRepository requestRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public PersonelService(UserRepository userRepository, PersonelRepository personelRepository, RequestRepository requestRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.personelRepository = personelRepository;
        this.requestRepository = requestRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public Personel save(Personel personel) {
        return personelRepository.save(personel);
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
