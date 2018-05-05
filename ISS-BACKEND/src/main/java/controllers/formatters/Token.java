package controllers.formatters;

public class Token {
    private long id;
    private String firstname;
    private String personType;

    public Token(long id, String firstname, String personType) {
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

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
}
