package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bo.AccountBO;
import ultils.UltilsService;

@WebServlet("/login/LoginController")
public class LoginController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login_account") != null) {
			String destination = null;
			AccountBO accountBO = new AccountBO();
			UltilsService ultilsService = new UltilsService();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Account user = new Account();
			try {
				user = accountBO.loginAccount(email, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (user == null) {
				destination = "/login/index.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} else {
				if (user.getRole().equals("admin")) {
					request.getSession().setAttribute("user", user);
//					destination = "/home/admin.jsp";
//					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//					rd.forward(request, response);
					System.out.print(user.getRole());
				} else if (user.getRole().equals("chutro")) {
					request.getSession().setAttribute("user", user);
//					destination = "/home/admin.jsp";
//					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//					rd.forward(request, response);
					System.out.print(user.getRole());
				} else {
					request.getSession().setAttribute("user", user);
//					destination = "/home/admin.jsp";
//					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//					rd.forward(request, response);
					System.out.print(user.getRole());
				}
			}
		}
	}
}
