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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		User user = null;
		try {
			user = userBO.getUserByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/form_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");

		String role = request.getParameter("role");
		boolean enabled = Boolean.parseBoolean(request.getParameter("isEnabled"));

		// Tạo đối tượng User với thông tin mới
		User updatedUser = new User();
		updatedUser.setEmail(email);
		updatedUser.setAddress(address);
		updatedUser.setFullName(fullName);
		updatedUser.setPassword(password);
		updatedUser.setRole(Role.valueOf(role));
		updatedUser.setEnabled(enabled);

		try {
			// Gọi phương thức updateUser để cập nhật thông tin người dùng
			userBO.updateUser(updatedUser);

			// Chuyển hướng đến trang hiển thị thông báo cập nhật thành công hoặc trang
			// chính
			response.sendRedirect("index");
		} catch (SQLException e) {
			// Xử lý lỗi nếu cần thiết
			e.printStackTrace();
			// Chuyển hướng đến trang hiển thị thông báo lỗi
			response.sendRedirect("/error.jsp");
		}
	}

}
