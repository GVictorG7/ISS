package controllers.formatters;

public class DonorFields {
    private String firstName;
    private String lastName;
    private String cnp;
    private String gender;
    private String birthday;
    private String address;
    private String localAddress;
    private String email;
    private String phone;
    private Long userId;
    public DonorFields(){}
    public DonorFields(String firstName, String lastName, String cnp, String gender, String birthday, String address, String localAddress, String email, String phone, Long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.localAddress = localAddress;
        this.email = email;
        this.phone = phone;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
