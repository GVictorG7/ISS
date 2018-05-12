package controllers.formatters;

import model.PersonType;

public class Token {
    private long id;
    private String firstname;
    private PersonType personType;

    public Token(long id, String firstname, PersonType personType) {
        this.id = id;
        this.firstname = firstname;
        this.personType = personType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
