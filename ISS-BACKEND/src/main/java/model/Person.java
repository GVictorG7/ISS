package model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import validators.PersonValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Validated(value = PersonValidator.class)
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final long id = 1L;

    @Size(min=3, max=25)
    @Column(name = "first_name")
    private String firstName;

    @Size(min=3, max=40)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 13, max = 13, message = "Must have 13 numbers") // :))
    @Column(name = "cnp",unique = true)
    private String cnp;

    @Column(name = "gender")
    private String gender;

    @Column(name = "person_type")
    private String personType;

    public Person() {
    }

    public Person(String firstName, String lastName, String password, String cnp, String gender, String personType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.cnp = cnp;
        this.gender = gender;
        this.personType = personType;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

}
