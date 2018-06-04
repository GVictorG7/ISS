package controllers.formatters;

public class DoctorFields {
    private String firstName;
    private String lastName;
    private Long userId;
    private Long hospitalId;

    public DoctorFields() {
    }

    public DoctorFields(String firstName, String lastName, Long userId, Long userHospital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.hospitalId = userHospital;
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

    public Long getUserHospital() {
        return hospitalId;
    }

    public void setUserHospital(Long userHospital) {
        this.hospitalId = userHospital;
    }
}
