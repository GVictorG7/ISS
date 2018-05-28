package controllers.formatters;

public class RequestFields {
    private String person;
    private String requestDate;
    private int priority;
    private String bloodCategory;
    private String bloodRh;
    private String bloodType;
    private int bloodQuantity;
    private long idDoctor;

    public RequestFields() {
    }

    public RequestFields(String person, String requestDate, int priority, String bloodCategory, String bloodRh, String bloodType, int bloodQuantity, long idDoctor) {
        this.person = person;
        this.requestDate = requestDate;
        this.priority = priority;
        this.bloodCategory = bloodCategory;
        this.bloodRh = bloodRh;
        this.bloodType = bloodType;
        this.bloodQuantity = bloodQuantity;
        this.idDoctor = idDoctor;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }
    //status at new request will be open

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
