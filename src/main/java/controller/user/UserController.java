package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bean.enums.Role;
import model.bo.RoomBO;
import model.bo.UserBO;

@WebServlet("/user")
public class UserController extends HttpServlet{
	UserBO userBO=new UserBO();
	public void doGet(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		if(request.getParameter("logout")!=null) {
			request.getSession().removeAttribute("user");
			response.sendRedirect("./user/login.jsp");
		}
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
					response.sendRedirect("./admin/index");
				} else if (user.getRole().equals(Role.LANDLORD)) {
					request.getSession().setAttribute("user", user);
					response.sendRedirect("./landlord/boarding-house");
					
				} else if (user.getRole().equals(Role.TENANT)){
					request.getSession().setAttribute("user", user);
					response.sendRedirect("./tenant/boarding-house");
				}
			}
		}else if (request.getParameter("register_account") != null) {
			String destination = null;
			UserBO userBO = new UserBO();
			
			UUID userID = UUID.randomUUID();
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeat_password");
			String role = request.getParameter("role");
			User  user= new User();
			user.setId(userID);
			user.setFullName(fullname);
			user.setAddress(address);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(Role.valueOf(role));
			user.setEnabled(false);
			if (userBO.registerAccount(user) != -1) {
				response.sendRedirect("./user/login.jsp");
			} else {
				destination = "./user/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}else if (request.getParameter("add_member") != null) {
			String destination = null;
			String name = request.getParameter("name");
			String idroom = request.getParameter("idroom");
			String idbdh = request.getParameter("idbdh");
			System.out.print(idbdh);
			UserBO userBO = new UserBO();
			RoomBO roomBO = new RoomBO();
			User user = null;
			try {
				user = userBO.getUserByEmail(name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String userID = user.getId().toString();
			if (user != null) {
				if (roomBO.addMemberInRoom(userID, idroom) != -1) {
					response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + idbdh);
				}
			}
		}
	}
}
