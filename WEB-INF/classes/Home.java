import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Home extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		RequestDispatcher dispatcher;

		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		String password = user.getPassword();

		if ((username != null) && (password != null)) {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
	}
}