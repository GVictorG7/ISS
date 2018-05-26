package services;

import model.Donor;
import model.Medic;
import model.Personel;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonorRepository;
import repositories.MedicRepository;
import repositories.PersonelRepository;
import repositories.UserRepository;
import services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final DonorRepository donorRepository;
    private final MedicRepository medicRepository;
    private final PersonelRepository personelRepository;

    @Autowired
    public UserService(UserRepository userRepository, DonorRepository donorRepository, MedicRepository medicRepository, PersonelRepository personelRepository) {
        this.userRepository = userRepository;
        this.donorRepository = donorRepository;
        this.medicRepository = medicRepository;
        this.personelRepository = personelRepository;
    }

    /**
     * Authenticate user
     *
     * @param username = cnp in this state
     * @param password = user password
     * @return cnp (person unique field as a token / "Bad credentials if there is no match
     */
    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Donor getUserDonor(Long id) {
        return donorRepository.findByUser(userRepository.findById(id));
    }

    @Override
    public Medic getUserMedic(Long id) {
        return medicRepository.findByUser(userRepository.findById(id));
    }

    @Override
    public Personel getUserPersonel(Long id) {
        return personelRepository.findByUser(userRepository.findById(id));
    }

    @Override
    public User save(User person) {
        return userRepository.save(person);
    }

    @Override
    public User update(User updatedUser) {
        return  userRepository.save(updatedUser);
    }
}
