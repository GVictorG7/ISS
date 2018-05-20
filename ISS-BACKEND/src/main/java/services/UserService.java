package services;

import model.Donor;
import model.Medic;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonorRepository;
import repositories.MedicRepository;
import repositories.UserRepository;
import services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final DonorRepository donorRepository;
    private final MedicRepository medicRepository;


    @Autowired
    public UserService(UserRepository userRepository, DonorRepository donorRepository, MedicRepository medicRepository) {
        this.userRepository = userRepository;
        this.donorRepository = donorRepository;
        this.medicRepository = medicRepository;
    }


    /***
     * Authenticate user
     * @param username = cnp in this state
     * @param password = user password
     * @return cnp (person unique field as a token / "Bad credentials if there is no match
     */
    @Override
    public User login(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }


    @Override
    public Donor getUserDonor(Long id) {
        return donorRepository.getByUser(userRepository.getById(id));
    }

    @Override
    public Medic getUserMedic(Long id) {
        return medicRepository.getByUser(userRepository.getById(id));
    }

    @Override
    public User save(User person) {

        return userRepository.save(person);
    }

    @Override
    public User update(User updatedUser) {
        return null;
    }


}
