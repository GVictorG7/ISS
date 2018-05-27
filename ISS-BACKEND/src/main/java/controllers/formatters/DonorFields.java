package controllers.formatters;

import model.Blood;
import model.User;

import java.time.LocalDate;

public class DonorFields implements HasDateFormat{
    private String name;

    private LocalDate birthday;

    private String domiciliu;

    private String resedinta;

    private String email;

    private String phone;

    private String username;

    private Long idBlood;

    public DonorFields() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday, dateFormat);
    }

    public String getDomiciliu() {
        return domiciliu;
    }

    public void setDomiciliu(String domiciliu) {
        this.domiciliu = domiciliu;
    }

    public String getResedinta() {
        return resedinta;
    }

    public void setResedinta(String resedinta) {
        this.resedinta = resedinta;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdBlood() {
        return idBlood;
    }

    public void setIdBlood(Long idBlood) {
        this.idBlood = idBlood;
    }

    @Override
    public String toString() {
        return "DonorFields{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", domiciliu='" + domiciliu + '\'' +
                ", resedinta='" + resedinta + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", user=" + username +
                ", id_blood=" + idBlood +
                '}';
    }
}
