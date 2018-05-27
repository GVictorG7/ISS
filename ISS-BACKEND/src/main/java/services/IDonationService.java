package services;

import model.Donation;

import java.util.List;

public interface IDonationService {
    Donation getById(Long id);
    List<Donation> findAll();
    void save(Donation donation);
    Donation deleteById(Long id);
}
