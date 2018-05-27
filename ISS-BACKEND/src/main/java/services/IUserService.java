package services;

import model.User;

import java.util.List;

public interface IUserService {
    User getByUsername(String username);
    List<User> findAll();
    void save(User user);
    User deleteByUsername(String username);
}
