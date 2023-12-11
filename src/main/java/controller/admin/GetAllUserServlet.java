package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bo.UserBO;
import model.bean.User;
import model.bean.enums.Role;

@WebServlet("/admin/index")
public class GetAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.ADMIN)) {
		String destination = null;
		UserBO userBO = new UserBO();
		List<User> users = null;
		try {
			users = userBO.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("users", users);
		destination = "/admin/index.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
		}else {
			response.sendRedirect("../404.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
