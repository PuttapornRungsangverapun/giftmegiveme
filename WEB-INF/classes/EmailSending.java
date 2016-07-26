import javax.servlet.http.*;
import javax.servlet.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.*;
import java.util.*;
import javax.mail.*;

public class EmailSending {

  static String username = "thediezy";
  static String password = "11032529";

  public static int sendEmail(String to, String subject, String text) {

    try {
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session emailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sender_username","sender_password");
                }
        });

        emailSession.setDebug(true);
        Message message = new MimeMessage(emailSession);
        message.setFrom(new InternetAddress(
                "sender_username@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

        message.setSubject(subject);
        message.setText(text);
        Transport transport = emailSession.getTransport("smtps");
        transport.connect("smtp.gmail.com", username, password);
        transport.sendMessage(message, message.getAllRecipients());

        return 1;

       } catch (MessagingException e) {
        return 0;
      }
  }
}
