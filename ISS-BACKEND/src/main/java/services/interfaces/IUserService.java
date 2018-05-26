package services.interfaces;

import model.Donor;
import model.Medic;
import model.User;

public interface IUserService {
    User save(User user);

    User update(User updatedUser);

    User login(String username, String password);

    Donor getUserDonor(Long id);

    Medic getUserMedic(Long id);
}
