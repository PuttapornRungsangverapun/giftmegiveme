import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;

public class Deposit extends HttpServlet {

  private final DatabaseConnection openConnection = new DatabaseConnection();

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

		Connection connect = null;
		PreparedStatement statement = null;
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		ArrayList<Travel> list = new ArrayList <Travel>();

		try {
			connect = openConnection.getDatabaseConnection();
			if (request.getParameter("open") != null) {
				statement = connect.prepareStatement("update travel set travel_status='0' where travel_id=?");
				statement.setInt(1,Integer.parseInt(request.getParameter("open")));
				statement.executeUpdate();
			} else if (request.getParameter("close") != null) {
				statement = connect.prepareStatement("update travel set travel_status='1' where travel_id=?");
				statement.setInt(1,Integer.parseInt(request.getParameter("close")));
				statement.executeUpdate();
			}
			statement = connect.prepareStatement("select * from travel  where member_id=? order by travel_dateAnnounce desc");
			statement.setString(1,member.getIdCard());
			ResultSet rs = statement.executeQuery();

			while(rs.next()){
				Travel travel= new Travel();
				travel.setTravelId(rs.getInt("travel_id"));
				travel.setCountry(rs.getString("travel_country"));
				travel.setDetail(rs.getString("travel_detail"));
				travel.setStartDate(rs.getString("travel_dateStart"));
				travel.setEndDate(rs.getString("travel_dateEnd"));
				travel.setStatus(rs.getString("travel_status"));
				travel.setCurrentDate(rs.getString("travel_dateAnnounce"));
				list.add(travel);
			}
				session.setAttribute("travelList",list);
				rs.close();
				statement.close();
				connect.close();

				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
				rd.forward(request, response);
		} catch (SQLException e) {
		  e.printStackTrace();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			doGet(request, response);
	}
}
