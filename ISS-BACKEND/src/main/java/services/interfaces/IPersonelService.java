package services.interfaces;

import model.Donation;
import model.Personel;
import model.Request;
import model.User;

import java.util.List;

public interface IPersonelService {

    Personel save(Personel personel);

    List<Donation> getAllDonation();
    List<Request> getAllBloodRequest();
    User getUserPersonel(Long id);
}
