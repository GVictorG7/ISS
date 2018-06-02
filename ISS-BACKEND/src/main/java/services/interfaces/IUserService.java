package services.interfaces;

import model.Doctor;
import model.Donor;
import model.Personnel;
import model.User;

import java.util.List;

public interface IUserService {
    User save(User user);

    User update(User updatedUser);

    User login(String username, String password);

    Donor getUserDonor(Long id);

    Doctor getUserDoctor(Long id);

    Personnel getUserPersonel(Long id);

    List<String> getUsernames();
}
