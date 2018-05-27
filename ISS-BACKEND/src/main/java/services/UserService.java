package services;

import model.Doctor;
import model.Donor;
import model.Personnel;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DoctorRepository;
import repositories.DonorRepository;
import repositories.PersonnelRepository;
import repositories.UserRepository;
import services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final DonorRepository donorRepository;
    private final DoctorRepository doctorRepository;
    private final PersonnelRepository personnelRepository;

    @Autowired
    public UserService(UserRepository userRepository, DonorRepository donorRepository, DoctorRepository doctorRepository, PersonnelRepository personnelRepository) {
        this.userRepository = userRepository;
        this.donorRepository = donorRepository;
        this.doctorRepository = doctorRepository;
        this.personnelRepository = personnelRepository;
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
    public Doctor getUserDoctor(Long id) {
        return doctorRepository.findByUser(userRepository.findById(id));
    }

    @Override
    public Personnel getUserPersonel(Long id) {
        return personnelRepository.findByUser(userRepository.findById(id));
    }

    @Override
    public User save(User person) {
        return userRepository.save(person);
    }

    @Override
    public User update(User updatedUser) {
        return userRepository.save(updatedUser);
    }
}
