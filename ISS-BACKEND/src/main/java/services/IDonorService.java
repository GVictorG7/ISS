package services;

import model.Donor;

import java.util.List;

public interface IDonorService {
    Donor getById(Long id);
    List<Donor> findAll();
    void save(Donor donor);
    Donor deleteById(Long id);
}
