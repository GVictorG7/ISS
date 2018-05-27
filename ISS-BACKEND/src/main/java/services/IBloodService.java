package services;

import model.Blood;

import java.util.List;

public interface IBloodService {
    Blood save(Blood blood);
    void delete(Long id);
    List<Blood> getAll();
    Blood findById(Long id);
}
