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

    @OneToMany
    private List<Medic> medics;

    public Hospital() {
    }

    public Hospital(String name, List<Medic> medics) {
        this.name = name;
        this.medics = medics;
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

    public List<Medic> getMedics() {
        return medics;
    }

    public void setMedics(List<Medic> medics) {
        this.medics = medics;
    }

    public void addMedic(Medic medic) {
        medics.add(medic);
    }
}
