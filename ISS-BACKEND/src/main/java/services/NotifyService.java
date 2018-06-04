package services;

import org.springframework.stereotype.Service;
import services.interfaces.INotifyService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class NotifyService implements INotifyService {


    @Override
    public void sendMailToUsers(String[] users) {
        final String email = "donation.blood.request@gmail.com";
        final String password = "donationbloodrequest";

        final String subject = "Donate blood !";
        final String msg = "Hello Sir / Madam,\n" +
                "Urgent Blood Donation Request: " +
                "A person needs blood very urgently. " +
                "Any kind of blood would be accepted. " +
                "Please make your donations at the closest medical center. " +
                "Thank you !";


        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", email);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(email));
            InternetAddress[] recipientAddress = new InternetAddress[users.length];
            int counter = 0;
            for (String recipient : users) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.BCC, recipientAddress);
            message.setSubject(subject);
            message.setText(msg);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, email, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
