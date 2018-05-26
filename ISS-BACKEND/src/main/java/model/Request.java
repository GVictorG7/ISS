package model;

import org.springframework.validation.annotation.Validated;
import validators.RequestValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Date requestDate;

    @Column(name = "priority")
    private int priority;

    @Column(name = "blood_category")
    private String bloodCategory;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "blood_quantity")
    private int bloodQuantity;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "blood_id")
    private Blood blood;

    public Request() {
    }

    public Request(String person, Date requestDate, int priority, String bloodCategory, String bloodType, int bloodQuantity, Medic medic, Blood blood) {
        this.person = person;
        this.requestDate = requestDate;
        this.priority = priority;
        this.bloodCategory = bloodCategory;
        this.bloodType = bloodType;
        this.bloodQuantity = bloodQuantity;
        this.medic = medic;
        this.blood = blood;
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
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

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }
}
