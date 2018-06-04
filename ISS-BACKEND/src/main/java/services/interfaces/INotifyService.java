package services.interfaces;

public interface INotifyService {
    /**
     * Send emails to users
     *
     * @param users - list of string with users
     */
    void sendMailToUsers(String[] users);
}
