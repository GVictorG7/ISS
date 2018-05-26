package services.interfaces;

import model.Person;

public interface IPersonService {
    Person login(String username, String password);

    Person save(Person person);
}
