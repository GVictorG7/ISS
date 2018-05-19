package services;

import model.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.BloodRepository;


public class BloodService implements IBloodService {
    private final BloodRepository bloodRepository;

    @Autowired
    public BloodService(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }
    @Override
    public Blood save(Blood blood) {
        return null;
    }

    @Override
    public void delte(int id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void update(Blood blod) {

    }

    @Override
    public void findById(int id) {

    }
}
