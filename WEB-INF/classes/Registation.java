import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Registation extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();
	private static final String SAVE_DIR = "apache-tomcat-8.0.35\\webapps\\giftmegiveme\\picture";

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

		Connection connect = null;
		PreparedStatement statement = null;
		String getFileName = "";
		String fileName = "";
		String filePath = "";
		int checkInsertMember = 0;
		int checkInsertUser = 0;
		int user_id = 0;

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
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
				"INSERT INTO User(user_username, user_password) VALUES (?, ?)");
			statement.setString(1,request.getParameter("username"));
			statement.setString(2,EncryptionPassword.encrypt(request.getParameter("password")));
			checkInsertUser = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
				"SELECT * FROM user WHERE user_username = ?");
			statement.setString(1,request.getParameter("username"));
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				user_id = result.getInt("user_id");
			}
			result.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
				"INSERT INTO Member(member_id,member_firstname,member_lastname,member_gender,member_address,member_mobile,member_email,member_picture,member_idLine,user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1,request.getParameter("IDcard"));
			statement.setString(2,request.getParameter("firstname"));
			statement.setString(3,request.getParameter("lastname"));
			statement.setString(4,request.getParameter("gender"));
			statement.setString(5,request.getParameter("address"));
			statement.setString(6,request.getParameter("telephone"));
			statement.setString(7,request.getParameter("email"));
			statement.setString(8,filePath);
			statement.setString(9,request.getParameter("lineID"));
			statement.setInt(10,user_id);
			checkInsertMember = statement.executeUpdate();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (checkInsertMember == 1 && checkInsertUser == 1) {
			Member member = new Member();
			member.setIdCard(request.getParameter("IDcard"));
			member.setFirstName(request.getParameter("firstname"));
			member.setLastName(request.getParameter("lastname"));
			member.setEmail(request.getParameter("email"));
			member.setPhoneNumber(request.getParameter("telephone"));
			member.setAddress(request.getParameter("address"));
			member.setLineId(request.getParameter("lineID"));
			member.setGender(request.getParameter("gender"));
			member.setPicturePath(filePath);
			
			HttpSession session = request.getSession();
			session.setAttribute("member",member);

			String userId = user_id + "";
			String base64encodedString = Base64.getEncoder().encodeToString(userId.getBytes("utf-8"));

			int checkSendEmailSuccessful = EmailSending.sendEmail(request.getParameter("email"),"Hi test","http://"+InetAddress.getLocalHost().getHostAddress()+":8080/giftmegiveme/activate?id="+base64encodedString);

			if (checkSendEmailSuccessful == 1) {	
				RequestDispatcher rd = request.getRequestDispatcher("activate.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("not successful");
			}
		}
	}
}
