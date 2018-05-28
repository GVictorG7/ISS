package services;

import model.Donor;
import model.User;

import java.time.LocalDate;
import java.util.List;

public interface IDonorService {
    Donor getById(Long id);
    List<Donor> findAll();
    void save(String name, LocalDate birthday, String domiciliu, String resedinta, String email, String phone, String username);
    Donor deleteById(Long id);
}
