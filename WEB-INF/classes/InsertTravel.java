import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class InsertTravel extends HttpServlet {

	private final  DatabaseConnection myConnect = new DatabaseConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	try {
		if (request.getParameter("startDate") != null) {
			HttpSession session = request.getSession(false);
			Member member = (Member)session.getAttribute("member");	          
			Connection conn = myConnect.getDatabaseConnection();
			PreparedStatement prepstmt = conn.prepareStatement(
				"insert into travel (travel_country,travel_detail,travel_dateStart,travel_dateEnd,member_id,travel_status,travel_dateAnnounce) VALUES (?,?,?,?,?,?,?)");
			prepstmt.setString(1, request.getParameter("country"));
			prepstmt.setString(2, request.getParameter("detail"));
			prepstmt.setString(3, request.getParameter("startDate"));
			prepstmt.setString(4, request.getParameter("endDate"));
			prepstmt.setString(5, member.getIdCard());
			prepstmt.setString(6, "1");
			prepstmt.setString(7, request.getParameter("announceDate"));
			prepstmt.executeUpdate();

		if (request.getParameter("hashtag") !=null) {
			prepstmt = conn.prepareStatement(
				"select travel_id from travel where travel_dateStart = ? and member_id = ?");
			prepstmt.setString(1, request.getParameter("startDate"));
			prepstmt.setString(2, member.getIdCard());
			ResultSet rs = prepstmt.executeQuery();
			
			int travelId = 0;
			while (rs.next()) {
				travelId = rs.getInt("travel_id");
			}

			String hashtag = request.getParameter("hashtag");
			String[] hashtags = hashtag.split("#");

			for(int i = 1; i<hashtags.length; i++) {
				prepstmt = conn.prepareStatement(
					"insert into hashtag  (travel_id,hashtag_tag) VALUES (?,?)");
				prepstmt.setInt(1, travelId);
				prepstmt.setString(2, hashtags[i]);
				prepstmt.executeUpdate();
			}
			rs.close();
			prepstmt.close();
			conn.close();
		}
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
        }
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception se) {
		se.printStackTrace();
	}
	}
}