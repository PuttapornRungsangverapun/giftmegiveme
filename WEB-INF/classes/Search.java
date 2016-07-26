import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;
import org.apache.log4j.Logger;

public class Search extends HttpServlet {

	private static final Logger log = Logger.getLogger(Search.class);
	private final  DatabaseConnection myConnect = new DatabaseConnection();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		log.info("Start search");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

	try {
		String sql = "";
		PreparedStatement prepstmt = null;
		ResultSet rs = null;
		Connection conn = myConnect.getDatabaseConnection();
		boolean hashtag = false;
		ArrayList<SearchList> list = new ArrayList <SearchList>();

		sql = "select * from travel t,member m where t.member_id=m.member_id and t.travel_status='1' order by t.travel_dateAnnounce desc";
		prepstmt = conn.prepareStatement(sql);
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
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			ArrayList<HashtagList> hashtagList = new ArrayList <HashtagList>();
			sql = "SELECT hashtag_tag,count(*) FROM hashtag GROUP BY hashtag_tag order by COUNT(*) desc";
			prepstmt = conn.prepareStatement(sql);
			rs = prepstmt.executeQuery();
	        while (rs.next()) {
				HashtagList addHashtag = new HashtagList();
				addHashtag.setHashtagName(rs.getString("hashtag_tag"));
				hashtagList.add(addHashtag);
	        }
			session.setAttribute("hashtagList",hashtagList);
			rs.close();
			prepstmt.close();
			conn.close();

			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			log.info("Stop search");
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
