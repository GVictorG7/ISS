package services.interfaces;

import model.Donation;
import model.Personnel;
import model.Request;
import model.User;

import java.util.List;

public interface IPersonelService {

    Personnel save(Personnel personnel);

    List<Donation> getAllDonation();
    List<Request> getAllBloodRequest();
    User getUserPersonel(Long id);
}
