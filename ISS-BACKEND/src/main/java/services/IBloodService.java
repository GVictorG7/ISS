package services;

import model.Blood;

public interface IBloodService {
    Blood save(Blood blood);
    void delte(int id);
    void getAll();
    void update(Blood blod);
    void findById(int id);
}
