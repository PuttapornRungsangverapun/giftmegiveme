import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;

public class SearchPopular  extends HttpServlet {

	private final  DatabaseConnection myConnect = new DatabaseConnection();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			String sql = "";
			PreparedStatement prepstmt = null;
			ResultSet rs = null;
			Connection conn = myConnect.getDatabaseConnection();
			ArrayList<SearchList> list = new ArrayList <SearchList>();
			if (request.getParameter("popular") !="" || request.getParameter("popular") !=null ) {
				sql = "select * from travel t,member m,hashtag h where h.travel_id=t.travel_id and m.member_id=t.member_id and travel_status='1' "+
					  "and h.hashtag_tag=? order by t.travel_dateAnnounce desc";
				prepstmt = conn.prepareStatement(sql);
				prepstmt.setString(1,request.getParameter("popular"));
				rs = prepstmt.executeQuery();

				while (rs.next()) {
					SearchList searchlist= new SearchList();
					searchlist.setIdCard(rs.getString("member_id"));
					searchlist.setFirstName(rs.getString("member_firstname"));
					searchlist.setLastName(rs.getString("member_lastname"));
			        searchlist.setGender(rs.getString("member_gender"));
					searchlist.setAddress(rs.getString("member_address"));
					searchlist.setPhoneNumber(rs.getString("member_mobile"));
					searchlist.setEmail(rs.getString("member_email"));
					searchlist.setPicturePath(rs.getString("member_picture"));
			        searchlist.setLineId(rs.getString("member_idLine"));
			        searchlist.setTravelId(rs.getInt("travel_id"));
			        searchlist.setCountry(rs.getString("travel_country"));
			        searchlist.setDetail(rs.getString("travel_detail"));
					searchlist.setStartDate(rs.getString("travel_dateStart"));
			        searchlist.setEndDate(rs.getString("travel_dateEnd"));
			        searchlist.setStatus(rs.getString("travel_status"));
					searchlist.setCurrentDate(rs.getString("travel_dateAnnounce"));
					list.add(searchlist);
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			rs.close();
			prepstmt.close();
			conn.close();

			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			RequestDispatcher dispatcher = request.getRequestDispatcher("buy.jsp");
			dispatcher.forward(request, response);
		} catch (Exception se) {
			se.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
	}
}
