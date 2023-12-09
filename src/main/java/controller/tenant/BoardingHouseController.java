package controller.tenant;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BoardingHouse;
import model.bean.User;
import model.bean.enums.Role;
import model.bo.BoardingHouseBO;

@WebServlet("/tenant/boarding-house")
public class BoardingHouseController extends HttpServlet {
	BoardingHouseBO boardingHouseBO = new BoardingHouseBO();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.TENANT)) {

			List<BoardingHouse> boardingHouses = boardingHouseBO.getListBoardingHouseOfTenant(user.getId());
			request.setAttribute("boardingHouses", boardingHouses);
			request.getRequestDispatcher("/tenant/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("../404.jsp");
		}

	}
}
