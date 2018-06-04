package controllers.formatters;

public class RequestFields {
    private String forPerson;
    private String priority;
    private String bloodCategory;
    private String bloodRh;
    private String bloodType;
    private int bloodQuantity;
    private long idDoctor;

    public RequestFields() {
    }

    public RequestFields(String forPerson, String priority, String bloodCategory, String bloodRh, String bloodType, int bloodQuantity, long idDoctor) {
        this.forPerson = forPerson;
        this.priority = priority;
        this.bloodCategory = bloodCategory;
        this.bloodRh = bloodRh;
        this.bloodType = bloodType;
        this.bloodQuantity = bloodQuantity;
        this.idDoctor = idDoctor;
    }


    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }
    //status at new request will be open

    public String getForPerson() {
        return this.forPerson;
    }

    public void setForPerson(String forPerson) {
        this.forPerson = forPerson;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public String getBloodRh() {
        return bloodRh;
    }

    public void setBloodRh(String bloodRh) {
        this.bloodRh = bloodRh;
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
}
