package services;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PersonRepository;
import services.interfaces.IPersonService;

@Service
public class PersonService implements IPersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Authenticate user (person)
     *
     * @param username = cnp in this state
     * @param password = user password
     * @return cnp (person unique field as a token / "Bad credentials if there is no match
     */
    @Override
    public Person login(String username, String password) {
        return personRepository.getByCnpAndPassword(username, password);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
