package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final long id = 1L;

    @NotNull
    @Column
    @OneToMany
    private Person person;
    @NotNull
    @Column(name = "pregnant")
    private boolean pregnant;
    @NotNull
    @Column(name = "menstruating")
    private boolean menstruating;
    @NotNull
    @Column(name = "consumedDrinks")
    private boolean consumedDrinks;
    @NotNull
    @Column(name = "systolic")
    private int systolic;
    @NotNull
    @Column(name = "pulse")
    private int pulse;
    @NotNull
    @Column(name = "forPerson")
    private String forPerson;
    @NotNull
    @Column(name = "smoked")
    private boolean smoked;
    @NotNull
    @Column(name = "wellSlept")
    private boolean wellSlept;
    @NotNull
    @Column(name = "bloodType")
    private BloodType bloodType;
    @NotNull
    @Column(name = "rh")
    private boolean rh;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id")
    private DiseaseReport diseaseReport;



    public Donation(Person person, boolean pregnant, boolean menstruating, boolean consumedDrinks, int systolic, int pulse, String forPerson, boolean smoked, boolean wellSlept, BloodType bloodType, boolean rh, DiseaseReport diseaseReport) {
        this.person=person;
        this.pregnant = pregnant;
        this.menstruating = menstruating;
        this.consumedDrinks = consumedDrinks;
        this.systolic = systolic;
        this.pulse = pulse;
        this.forPerson = forPerson;
        this.smoked = smoked;
        this.wellSlept = wellSlept;
        this.bloodType = bloodType;
        this.rh = rh;
        this.diseaseReport = diseaseReport;
    }

    public long getId() {
        return id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



//
//    public Date getExprieDate(){
//
//        //Specifying date format that matches the given date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();
//        try{
//            //Setting the date to the given date
//            c.setTime(sdf.parse(String.valueOf(colectionDate)));
//        }catch(ParseException e){
//            e.printStackTrace();
//        }
//
//        c.add(Calendar.DAY_OF_MONTH, blood.getExpireDate());
//        return c.getTime();
//



    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isMenstruating() {
        return menstruating;
    }

    public void setMenstruating(boolean menstruating) {
        this.menstruating = menstruating;
    }

    public boolean isConsumedDrinks() {
        return consumedDrinks;
    }

    public void setConsumedDrinks(boolean consumedDrinks) {
        this.consumedDrinks = consumedDrinks;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getForPerson() {
        return forPerson;
    }

    public void setForPerson(String forPerson) {
        this.forPerson = forPerson;
    }

    public boolean isSmoked() {
        return smoked;
    }

    public void setSmoked(boolean smoked) {
        this.smoked = smoked;
    }

    public boolean isWellSlept() {
        return wellSlept;
    }

    public void setWellSlept(boolean wellSlept) {
        this.wellSlept = wellSlept;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public DiseaseReport getDiseaseReport() {
        return diseaseReport;
    }

    public void setDiseaseReport(DiseaseReport diseaseReport) {
        this.diseaseReport = diseaseReport;
    }
}
