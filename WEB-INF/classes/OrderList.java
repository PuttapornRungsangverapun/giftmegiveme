import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.io.*;
import java.net.*;
import java.util.*;

public class OrderList extends HttpServlet {

	private final DatabaseConnection openConnection = new DatabaseConnection();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		ArrayList<OrderHistory> list = new ArrayList <OrderHistory>();

		try {
			connect = openConnection.getDatabaseConnection();
			statement = connect.prepareStatement(
				"SELECT * FROM travel t,member m,buy b where m.member_id=b.member_id and t.travel_id=b.travel_id " +
				"and t.member_id = ? and t.travel_id=?");
			statement.setString(1,member.getIdCard());
			statement.setString(2,request.getParameter("detail"));
			rs = statement.executeQuery();

			while (rs.next()) {
				OrderHistory buyorderlist = new OrderHistory();
				buyorderlist.setProductName(rs.getString("buy_name"));
				buyorderlist.setPicProduct(rs.getString("buy_picture"));
				buyorderlist.setPriceProduct(rs.getDouble("buy_price"));
				buyorderlist.setPiece(rs.getInt("buy_amount"));
				buyorderlist.setCurrentDate(rs.getString("buy_date"));
				buyorderlist.setNameMember(rs.getString("member_firstname"));
				buyorderlist.setIdCard(rs.getString("member_id"));
				list.add(buyorderlist);
			}
			session.setAttribute("buyorderlist",list);

			rs.close();
			statement.close();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("orderlist.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
	}
}
