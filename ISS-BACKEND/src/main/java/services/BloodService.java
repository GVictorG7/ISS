package services;

import model.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;

import java.util.List;

@Service
public class BloodService implements IBloodService {
    private final BloodRepository bloodRepository;

    @Autowired
    public BloodService(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }
    @Override
    public Blood save(Blood blood) {
        return bloodRepository.save(blood);
    }

    @Override
    public void delete(Long id) {bloodRepository.delete(id);}

    @Override
    public List<Blood> getAll() {return bloodRepository.findAll();}


    @Override
    public Blood findById(Long id) {return bloodRepository.getById(id);}
}
