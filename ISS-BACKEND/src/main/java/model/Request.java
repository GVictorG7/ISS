package model;

import org.springframework.validation.annotation.Validated;
import validators.RequestValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Validated(value = RequestValidator.class)
@Entity
@Table(name = "Requests")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "for_person")
    private String forPerson;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private RequestPriority priority;

    @Column(name = "blood_category")
    @Enumerated(EnumType.STRING)
    private BloodCategory bloodCategory;

    @Column(name = "blood_rh")
    private BloodRH bloodRH;

    @Column(name = "blood_type")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "blood_quantity")
    private int bloodQuantity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    public Request() {}

    public Request(String forPerson, LocalDate requestDate, RequestPriority priority, BloodCategory bloodCategory, BloodRH bloodRH, BloodType bloodType, int bloodQuantity, RequestStatus status, Doctor doctor) {
        this.forPerson = forPerson;
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


    public String getForPerson() {
        return forPerson;
    }

    public void setForPerson(String forPerson) {
        this.forPerson = forPerson;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public RequestPriority getPriority() {
        return priority;
    }

    public void setPriority(RequestPriority priority) {
        this.priority = priority;
    }

    public BloodCategory getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(BloodCategory bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public BloodRH getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.bloodRH = bloodRH;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public int getBloodQuantity() {
        return bloodQuantity;
    }

    public void setBloodQuantity(int bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


}
