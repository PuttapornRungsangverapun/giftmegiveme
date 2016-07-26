import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Edit extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();
	private static final String SAVE_DIR="apache-tomcat-8.0.35\\webapps\\giftmegiveme\\picture";

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
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Connection connect = null;
		PreparedStatement statement = null;
		InputStream inputStream = null;
		HttpSession session = request.getSession();
		int checkInsertMember = 0;
		int checkInsertUser = 0;
		User userId = (User)session.getAttribute("user");
		int id = userId.getUserId();
		Member idCard = (Member)session.getAttribute("member");
		String member_idCard = idCard.getIdCard();
		String savePath = "C:" + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		String getFileName = "";
		String fileName = "";
		String filePath = "";

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
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
				"UPDATE user SET user_username = ?, user_password = ? WHERE user_id = ? ");
			statement.setString(1,request.getParameter("username"));
			statement.setString(2,EncryptionPassword.encrypt(request.getParameter("password")));
			statement.setInt(3,id);
			checkInsertUser = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
			  "UPDATE member SET member_firstname = ?,member_lastname = ?,member_address = ?,member_mobile = ?,member_email = ?,member_picture = ?,member_idLine = ? WHERE user_id = ?");
			statement.setString(1,request.getParameter("firstname"));
			statement.setString(2,request.getParameter("lastname"));
			statement.setString(3,request.getParameter("address"));
			statement.setString(4,request.getParameter("telephone"));
			statement.setString(5,request.getParameter("email"));
			statement.setString(6, filePath);
			statement.setString(7,request.getParameter("lineID"));
			statement.setInt(8,id);
			checkInsertMember = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			if (checkInsertMember == 1 && checkInsertUser == 1) {
			Member member = new Member();
			member.setIdCard(member_idCard);
			member.setFirstName(request.getParameter("firstname"));
			member.setLastName(request.getParameter("lastname"));
			member.setEmail(request.getParameter("email"));
			member.setPhoneNumber(request.getParameter("telephone"));
			member.setPicturePath(filePath);
			member.setAddress(request.getParameter("address"));
			member.setLineId(request.getParameter("lineID"));

			session.setAttribute("member",member);
			RequestDispatcher rd = request.getRequestDispatcher("editprofilesuccess.jsp");
			rd.forward(request, response);
		}
	}
}
