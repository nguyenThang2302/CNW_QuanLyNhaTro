package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bo.AccountBO;
import ultils.UltilsService;

@WebServlet("/register/RegisterController")
public class RegisterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("register_account") != null) {
			String destination = null;
			AccountBO accountBO = new AccountBO();
			UltilsService ultilsService = new UltilsService();
			String userID = UUID.randomUUID().toString();
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeat_password");
			String role = request.getParameter("role");
			Boolean isEnable = false;
			Account newAccount = new Account(userID, fullname, email, address, isEnable, password, role);
			if (accountBO.registerAccount(newAccount) != -1) {
				destination = "/login/index.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} else {
				destination = "/register/index.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
	}
}
