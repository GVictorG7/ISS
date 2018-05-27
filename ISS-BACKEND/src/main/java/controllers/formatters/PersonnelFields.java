package controllers.formatters;

public class PersonelFields {
    private long id;
    private String firstName;
    private String lastName;

    private Long userId;
    public PersonelFields(){};

    public PersonelFields(long id, String firstName, String lastName, Long userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
