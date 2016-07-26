import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.util.*;

public class Activation extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

	Connection connect = null;
  PreparedStatement statement = null;
	String id = request.getParameter("id");
	byte[] base64decodedBytes = Base64.getDecoder().decode(id);
	String decodeId = new String(base64decodedBytes, "utf-8");


		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement("SELECT * FROM user WHERE user_id = ?");
			statement.setInt(1,Integer.valueOf(decodeId));
			ResultSet result = statement.executeQuery();
			String activate = "1";
			String user_username = "";
			String user_password = "";
			int user_id = 0;

			while (result.next()) {

				activate = result.getString("user_activate");
				user_id = result.getInt("user_id");
				user_username = result.getString("user_username");
				user_password = result.getString("user_password");

			}

			if (activate.equals("0")) {
				try {
					statement = connect.prepareStatement("UPDATE User SET user_activate = ? WHERE user_id = ?");
					statement.setInt(1,1);
					statement.setInt(2,Integer.valueOf(decodeId));

					HttpSession session = request.getSession();
					User user = new User();
					user.setUserId(user_id);
					user.setUsername(user_username);
					user.setPassword(user_password);
					session.setAttribute("user", user);

					int check = statement.executeUpdate();

					if (check == 1) {
						statement = connect.prepareStatement("SELECT * FROM member WHERE user_id = ?");
						statement.setInt(1,Integer.valueOf(decodeId));
						result = statement.executeQuery();
						if (result.next()) {
							Member member = new Member();
							member.setIdCard(result.getString("member_id"));
							member.setFirstName(result.getString("member_firstname"));
							member.setLastName(result.getString("member_lastname"));
							member.setGender(result.getString("member_gender"));
							member.setAddress(result.getString("member_address"));
							member.setPhoneNumber(result.getString("member_mobile"));
							member.setEmail(result.getString("member_email"));
							member.setPicturePath(result.getString("member_picture"));
							member.setLineId(result.getString("member_idLine"));
							session.setAttribute("member", member);
						}
						result.close();
						statement.close();
						connect.close();

						RequestDispatcher rd = request.getRequestDispatcher("activationsuccess.jsp");
						rd.forward(request, response);
					} else {
						System.out.println("not successful");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
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
