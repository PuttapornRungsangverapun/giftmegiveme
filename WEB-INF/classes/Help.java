import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Help extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	String username = "thediezy";
    String password = "11032529";
    String result = null;
    String randomNumber ="";
    Random getRandom = new Random();

    try {
		Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session emailSession = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sender_username","sender_password");
			}
        });

        emailSession.setDebug(true);
        Message message = new MimeMessage(emailSession);
        message.setFrom(new InternetAddress("sender_username@gmail.com"));
		String userEmail = request.getParameter("email");
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
                
		for(int i = 0; i < 5; i++){
			int r = getRandom.nextInt(10);
			randomNumber += r;
		}
            
        message.setSubject("Test mail from JSP");
        message.setText("Hello Noob fuck guy"+ randomNumber);
        Transport transport = emailSession.getTransport("smtps");
        transport.connect("smtp.gmail.com", username, password);
		transport.sendMessage(message, message.getAllRecipients());

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}