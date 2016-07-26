import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HashtagSelection extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();
	private static final String SAVE_DIR = "apache-tomcat-8.0.35\\webapps\\giftmegiveme\\picture";

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Connection connect = null;
    PreparedStatement statement = null;
    int position = Integer.parseInt(request.getParameter("index"));

    HttpSession session = request.getSession();
    ArrayList list = (ArrayList)session.getAttribute("list");

    SearchList myList = (SearchList)list.get(position);

    ArrayList<HashtagList> hashtagList = new ArrayList <HashtagList>();
    try {
    connect = openConnection.getDatabaseConnection();
    statement = connect.prepareStatement("SELECT hashtag_tag FROM hashtag WHERE travel_id=?");
    statement.setInt(1,myList.getTravelId());

    ResultSet rs = statement.executeQuery();
        while (rs.next()) {
          HashtagList addHashtag = new HashtagList();
          addHashtag.setTagName(rs.getString("hashtag_tag"));
          hashtagList.add(addHashtag);
        }

    session.setAttribute("tagList",hashtagList);

    RequestDispatcher rd = request.getRequestDispatcher("buyDetail.jsp");
    rd.forward(request, response);

  } catch (SQLException e) {
    e.printStackTrace();
  } catch (Exception e) {
    e.printStackTrace();
  }

}}
