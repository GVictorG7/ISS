package controllers.formatters;

import model.User;

public class UserFields {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User generateUser(){
        return new User(username, password);
    }

    @Override
    public String toString() {
        return "UserFields{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
