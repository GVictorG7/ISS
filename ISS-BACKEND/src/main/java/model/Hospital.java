package model;

import org.springframework.validation.annotation.Validated;
import validators.HospitalValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Validated(value = HospitalValidator.class)
@Entity
@Table(name = "Hospitals")
public class Hospital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Doctor> doctors;

    public Hospital() {
    }

    public Hospital(String name, String address, List<Doctor> doctors) {
        this.name = name;
        this.address = address;
        this.doctors = doctors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addMedic(Doctor doctor) {
        doctors.add(doctor);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
