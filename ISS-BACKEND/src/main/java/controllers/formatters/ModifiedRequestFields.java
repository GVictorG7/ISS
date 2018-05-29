package controllers.formatters;

public class ModifiedRequestFields {
    private Long id;
    private String newStatus;

    public ModifiedRequestFields() {
    }

    public ModifiedRequestFields(Long id, String newStatus) {
        this.id = id;
        this.newStatus = newStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
