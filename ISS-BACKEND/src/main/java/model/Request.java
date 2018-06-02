package model;

import org.springframework.validation.annotation.Validated;
import validators.RequestValidator;

import javax.persistence.*;
import java.io.Serializable;

@Validated(value = RequestValidator.class)
@Entity
@Table(name = "Requests")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "person")
    private String person;

    @Column(name = "request_date")
    private String requestDate;

    @Column(name = "priority")
    private int priority;

    @Column(name = "blood_category")
    private String bloodCategory;

    @Column(name = "blood_rh")
    private String bloodRH;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "blood_quantity")
    private int bloodQuantity;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Request() {
    }

    public Request(String person, String requestDate, int priority, String bloodCategory, String bloodRH, String bloodType, int bloodQuantity, String status, Doctor doctor) {
        this.person = person;
        this.requestDate = requestDate;
        this.priority = priority;
        this.bloodCategory = bloodCategory;
        this.bloodRH = bloodRH;
        this.bloodType = bloodType;
        this.bloodQuantity = bloodQuantity;
        this.status = status;
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getBloodQuantity() {
        return bloodQuantity;
    }

    public void setBloodQuantity(int bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(String bloodRH) {
        this.bloodRH = bloodRH;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
