import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;

public class ResetPassword extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		Connection connect = null;
  		PreparedStatement statement = null;
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("user_id");

		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement("UPDATE user SET user_password = ? WHERE user_id = ?");
			statement.setString(1,EncryptionPassword.encrypt(request.getParameter("password")));
			statement.setInt(2,id);

			int check = statement.executeUpdate();
			statement.close();
			connect.close();

			if (check == 1) {          
			  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			  rd.forward(request, response);
			}
		} catch (SQLException e) {
  			e.printStackTrace();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
	}
}
