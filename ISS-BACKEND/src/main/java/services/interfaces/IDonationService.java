package services.interfaces;

import model.Donation;
import model.Donor;

import java.util.List;

public interface IDonationService {
    void save(Donation donation);

    void update(Donation updateDonation);

    Donation getById(Long id);

    List<Donation> findAllByDonor(Donor donor);
}
