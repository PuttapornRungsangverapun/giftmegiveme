import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;

public class FindSearch extends HttpServlet {

	private final DatabaseConnection myConnect = new DatabaseConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
	try {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		String sql = "";
		PreparedStatement prepstmt = null;
		ResultSet rs = null;
		Connection conn = myConnect.getDatabaseConnection();
		boolean hashtag = false;
		ArrayList<SearchList> arraylist = new ArrayList<SearchList>();

		if (request.getParameter("search") == null || request.getParameter("search") =="") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("search");
			dispatcher.forward(request, response);
		} else {

		String checkHashtag = request.getParameter("search");
		if (checkHashtag.charAt(0) == '#')
		hashtag = true;

		if (hashtag == true) {
			String countHashtag[] = checkHashtag.split("#");

			for (int i = 1; i < countHashtag.length; i++) {
				sql = "select * from travel t,member m,hashtag h where t.member_id=m.member_id and t.travel_status='1' and t.travel_id=h.travel_id and h.hashtag_tag=? order by t.travel_dateAnnounce desc";
				prepstmt = conn.prepareStatement(sql);
				prepstmt.setString(1,countHashtag[i]);
				rs = prepstmt.executeQuery();
				while (rs.next()) {
					SearchList searchlist = new SearchList();
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
					searchlist.setHashTag(rs.getString("hashtag_tag"));
					arraylist.add(searchlist);
				}
			}
				session.setAttribute("list", arraylist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("buy.jsp");
				dispatcher.forward(request, response);
		} else {
			sql = "select * from travel t,member m where t.member_id=m.member_id and t.travel_status='1' and  t.travel_country like ? order by t.travel_dateAnnounce desc";
			prepstmt = conn.prepareStatement(sql);
			prepstmt.setString(1, request.getParameter("search") + "%");
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				SearchList searchlist = new SearchList();
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
				arraylist.add(searchlist);
			}
				session.setAttribute("list", arraylist);
				rs.close();
				prepstmt.close();
				conn.close();

				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("buy.jsp");
				dispatcher.forward(request, response);
			}
		}
	} catch (Exception se) {
		se.printStackTrace();
	}
  }
}