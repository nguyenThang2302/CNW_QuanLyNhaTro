package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bean.enums.Role;
import model.bo.UserBO;

@WebServlet("/user")
public class UserController extends HttpServlet{
	UserBO userBO=new UserBO();
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.print(111);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login") != null) {
			String destination = null;
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User();
			try {
				user = userBO.loginAccount(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (user == null) {
				destination = "/login/index.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} else {
				if (user.getRole().equals(Role.ADMIN)) {
					request.getSession().setAttribute("user", user);
					
				} else if (user.getRole().equals(Role.LANDLORD)) {
					request.getSession().setAttribute("user", user);
					response.sendRedirect("./landlord/index.jsp");
					
				} else if (user.getRole().equals(Role.TENANT)){
					request.getSession().setAttribute("user", user);
					destination = "/tenant/index.jsp";
					response.sendRedirect("./tenant/index.jsp");
				}
			}
		}
	}
}
