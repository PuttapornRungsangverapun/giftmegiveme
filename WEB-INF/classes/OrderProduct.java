import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderProduct extends HttpServlet {

	private final  DatabaseConnection myConnect = new DatabaseConnection();
	private static final String SAVE_DIR = "apache-tomcat-8.0.35\\webapps\\giftmegiveme\\product";

	private String extractFileName(Part part) {
 		String contentDisp = part.getHeader("content-disposition");
 		String[] items = contentDisp.split(";");
 		for (String s : items) {
			if (s.trim().startsWith("filename")) {
	 			return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
 		}
 		return "";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession(false);
		Member member = (Member)session.getAttribute("member");
		Connection conn = null;
		PreparedStatement prepstmt = null;
		String getFileName = "";
		String fileName = "";
		String filePath = "";

		String savePath = "C:" + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);

		if(!fileSaveDir.exists()){
 			fileSaveDir.mkdir();
		}

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String dateNow = dateFormat.format(date);

		Part part = request.getPart("photo");
 		getFileName = extractFileName(part);

 		if (getFileName.isEmpty()) {
			filePath =  "";
 		} else {
			fileName = dateNow + "_" + getFileName;
			part.write(savePath + File.separator + fileName);
			filePath = fileName;
 		}

		try {
			conn = myConnect.getDatabaseConnection();
			prepstmt = conn.prepareStatement(
				"INSERT INTO buy(travel_id,member_id,buy_name,buy_picture,buy_price,buy_amount,buy_date,buy_currency) VALUES (?,?,?,?,?,?,?,?)");
			prepstmt.setInt(1, Integer.parseInt(request.getParameter("travelId")));
			prepstmt.setString(2, member.getIdCard());
			prepstmt.setString(3, request.getParameter("productName"));
			prepstmt.setString(4, filePath);
			prepstmt.setDouble(5, Double.parseDouble(request.getParameter("price")));
			prepstmt.setInt(6, Integer.parseInt(request.getParameter("amount")));
			prepstmt.setString(7, dateNow);
			prepstmt.setString(8, request.getParameter("currencies"));
			prepstmt.executeUpdate();

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
