<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%

    String username = "thediezy";
    String password = "11032529";
    String result = null;
    String randomNumber ="";
    Random getRandom = new Random();
	Member member = (Member) request.getSession().getAttribute("member");
	System.out.println(member.getEmail());

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
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(member.getEmail());

			for(int i = 0; i < 4; i++){
				int r = getRandom.nextInt(10);
				randomNumber += r;
           }

        message.setSubject("Test mail from JSP");
        message.setText("Please confirm 4 digit " + randomNumber);
        Transport transport = emailSession.getTransport("smtps");
        transport.connect("smtp.gmail.com", username, password);
        transport.sendMessage(message, message.getAllRecipients());

        result = "Successfully sent email";

       } catch (MessagingException e) {
        result = "Unable to send email";
    }
%>
<html>
<head>
<title>Send Email using JSP</title>
</head>
<body>
    <center>
        <h1>Send Email using JSP</h1>
    </center>
    <p align="center">
        <%
            out.println("Result: " + result + "\n");
        %>
    </p>
</body>
</html>
