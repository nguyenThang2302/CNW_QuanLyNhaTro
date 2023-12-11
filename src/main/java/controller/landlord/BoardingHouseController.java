package controller.landlord;

import model.bean.enums.Role;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BoardingHouse;
import model.bean.Room;
import model.bean.User;
import model.bo.BoardingHouseBO;
import model.bo.RoomBO;

@WebServlet("/landlord/boarding-house")
public class BoardingHouseController extends HttpServlet {
	BoardingHouseBO boardingHouseBO = new BoardingHouseBO();
	RoomBO roomBO = new RoomBO();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
			if (request.getParameter("id") != null) {
				UUID boardingHouseId = UUID.fromString(request.getParameter("id"));
				BoardingHouse boardingHouse = boardingHouseBO.getBoardingHouseById(null, boardingHouseId);
				request.setAttribute("boardingHouse", boardingHouse);
				request.getRequestDispatcher("/landlord/boarding-house/update.jsp").forward(request, response);
			} else {
				List<BoardingHouse> boardingHouses = boardingHouseBO.getListBoardingHouse(user.getId());
				request.setAttribute("boardingHouses", boardingHouses);
				request.getRequestDispatcher("/landlord/index.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("../404.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
		if (request.getParameter("create") != null) {
			System.out.print(1111);
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String electricity = request.getParameter("electricity");
			String water = request.getParameter("water");

			BoardingHouse boardingHouse = new BoardingHouse();
			boardingHouse.setAddress(address);
			boardingHouse.setName(name);
			boardingHouse.setElectricityUnitPrice(Double.parseDouble(electricity));
			boardingHouse.setWaterUnitPrice(Double.parseDouble(water));

			if (boardingHouseBO.create(boardingHouse,  user.getId())) {
				List<BoardingHouse> boardingHouses = boardingHouseBO
						.getListBoardingHouse( user.getId());
				request.setAttribute("boardingHouses", boardingHouses);
				request.getRequestDispatcher("/landlord/boarding-house/boardingHouseList.jsp").forward(request,
						response);
			}
		}
		if (request.getParameter("update") != null) {
			System.out.print(2222);
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String electricity = request.getParameter("electricity");
			String water = request.getParameter("water");
			BoardingHouse boardingHouse = new BoardingHouse();
			boardingHouse.setId(UUID.fromString(id));
			boardingHouse.setAddress(address);
			boardingHouse.setName(name);
			boardingHouse.setElectricityUnitPrice(Double.parseDouble(electricity));
			boardingHouse.setWaterUnitPrice(Double.parseDouble(water));

			if (boardingHouseBO.update(boardingHouse, user.getId())) {
				List<BoardingHouse> boardingHouses = boardingHouseBO
						.getListBoardingHouse( user.getId());
				request.setAttribute("boardingHouses", boardingHouses);
				request.getRequestDispatcher("/landlord/boarding-house/boardingHouseList.jsp").forward(request,
						response);
			}
		}
		} else {
			response.sendRedirect("../404.jsp");
		}
	}
}
