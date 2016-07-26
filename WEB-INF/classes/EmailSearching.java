import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;

public class EmailSearching extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

	Connection connect = null;
	PreparedStatement statement = null;
	int user_id = 0;
	HttpSession session = request.getSession();

		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement("SELECT * FROM member WHERE member_email=?");
			statement.setString(1,request.getParameter("email"));
			ResultSet result = statement.executeQuery();

			int userId = 0;

			while (result.next()) {
				userId = result.getInt("user_id");
				System.out.println(userId);
			}

			if (userId > 0) {
				session.setAttribute("user_id", userId);
				int checkSendEmailSuccessful = EmailSending.sendEmail(request.getParameter("email"),"Reset your password","http://"+InetAddress.getLocalHost().getHostAddress()+":8080/giftmegiveme/resetpassword.jsp");

				if (checkSendEmailSuccessful == 1) {
					result.close();
					statement.close();
					connect.close();

					RequestDispatcher rd = request.getRequestDispatcher("sendresetpassword.jsp");
					rd.forward(request, response);
				} else {
					System.out.println("not successful");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
