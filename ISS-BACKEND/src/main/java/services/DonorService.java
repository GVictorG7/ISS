package services;

import model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DonorRepository;

import java.util.List;

@Service
public class DonorService implements IDonorService{
    public final DonorRepository donorRepository;

    @Autowired
    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
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
    public void save(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public Donor deleteById(Long id) {
        return donorRepository.deleteById(id);
    }
}
