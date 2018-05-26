package controllers.formatters;

public class ReturnObject {
    private Object userData;
    private String userType;

    public ReturnObject(Object userData, String userType) {
        this.userData = userData;
        this.userType = userType;
    }



    public Object getUserData() {
        return userData;
    }

    public void setUserData(Object userData) {
        this.userData = userData;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
