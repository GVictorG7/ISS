package services;

import model.Donor;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonorRepository;
import repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DonorService implements IDonorService{
    public final DonorRepository donorRepository;
    public final UserRepository userRepository;

    @Autowired
    public DonorService(DonorRepository donorRepository, UserRepository userRepository) {
        this.donorRepository = donorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Donor getById(Long id) {
        return donorRepository.getById(id);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public void save(String name, LocalDate birthday, String domiciliu, String resedinta, String email, String phone,String username) {
        donorRepository.save(new Donor(
                name,
                birthday,
                domiciliu,
                resedinta,
                email,
                phone,
                userRepository.getById(username)
        ));
    }

    @Override
    public Donor deleteById(Long id) {
        return donorRepository.deleteById(id);
    }
}
