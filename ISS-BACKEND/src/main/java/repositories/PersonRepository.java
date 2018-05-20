package repositories;

import model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getByCnpAndPassword(String cnp, String password);
    Person save(Person person);
}
