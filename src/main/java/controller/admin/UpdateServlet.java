package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.UserBO;
import model.dao.UserDAO;
import model.bean.User;
import model.bean.enums.Role;

@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
		String email = request.getParameter("email");
		User userInfo = null;
		try {
			userInfo = userBO.getUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("/admin/form_update.jsp").forward(request, response);
		}else {
			response.sendRedirect("../404.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.ADMIN)) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");

		String role = request.getParameter("role");
		boolean enabled = Boolean.parseBoolean(request.getParameter("isEnabled"));
		User updatedUser = new User();
		updatedUser.setEmail(email);
		updatedUser.setAddress(address);
		updatedUser.setFullName(fullName);
		updatedUser.setPassword(password);
		updatedUser.setRole(Role.valueOf(role));
		updatedUser.setEnabled(enabled);

		try {
			userBO.updateUser(updatedUser);		
			response.sendRedirect("index");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
		}else {
			response.sendRedirect("../404.jsp");
		}
	}

}
