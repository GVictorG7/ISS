package services.interfaces;

import model.Donation;
import model.Donor;
import model.User;

import java.util.List;

public interface IDonorService {
    void save(Donor donor);

    void update(Donor updatedDonor);

    Donor getById(Long id);

    User getUserDonor(Long id);
}
