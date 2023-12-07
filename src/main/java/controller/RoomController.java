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
import model.bean.Room;
import model.bo.BoardingHouseBO;
import model.bo.RoomBO;

@WebServlet("/landlord/boarding-house")
public class RoomController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("allroom") != null) {
			String destination = null;
			RoomBO roomBO = new RoomBO();
			ArrayList<Room> listRoom = null;
			try {
				listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("listRoom", listRoom);
			destination = "/room/roomList.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} else if (request.getParameter("deleteroom") != null) {
			RoomBO roomBO = new RoomBO();
			if (roomBO.deleteRoom(request.getParameter("deleteroom")) != -1) {
				ArrayList<Room> listRoom = null;
				try {
					listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listRoom", listRoom);
				response.sendRedirect("/QuanLyNhaTro/landlord/boarding-house?allroom=" + request.getParameter("idbdh"));
			}
		} else if (request.getParameter("updateroom") != null && request.getParameter("idbdh") != null) {
			String destination = null;
			RoomBO roomBO = new RoomBO();
			Room detailRoom = null;
			try {
				detailRoom = roomBO.getRoomByUUID(request.getParameter("updateroom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("detailRoom", detailRoom);
			destination = "/room/update.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("create_room") != null) {
			String destination = null;
			String roomID = UUID.randomUUID().toString();
			Account user = (Account) request.getSession().getAttribute("user");
			String idbdh = request.getParameter("idbdh");
			String name = request.getParameter("name");
			String numberProple = request.getParameter("number_people");
			String currentElectricty = request.getParameter("electricty");
			String currentWater = request.getParameter("water");
			String price = request.getParameter("price");
			String status = "empty";
			Room newRoom = new Room(roomID, name, idbdh, Integer.parseInt(numberProple), status,
					Integer.parseInt(currentElectricty), Integer.parseInt(currentWater), Double.parseDouble(price));
			BoardingHouseBO boardingHouseBO = new BoardingHouseBO();
			if (boardingHouseBO.createRoom(newRoom) != -1) {
				RoomBO roomBO = new RoomBO();
				ArrayList<Room> listRoom = null;
				try {
					listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listRoom", listRoom);
				response.sendRedirect("/QuanLyNhaTro/landlord/boarding-house?allroom=" + idbdh);
			}
		} else if (request.getParameter("update_room") != null) {
			String idbdh = request.getParameter("idbdh");
			String idroom = request.getParameter("idroom");
			String name = request.getParameter("name");
			String number_people = request.getParameter("number_people");
			String electricty = request.getParameter("electricty");
			String water = request.getParameter("water");
			String price = request.getParameter("price");
			String status = request.getParameter("status");
			Room updateRoom = new Room(idroom, name, idbdh, Integer.parseInt(number_people), status, Integer.parseInt(electricty), Integer.parseInt(water), Double.parseDouble(price));
			RoomBO roomBO = new RoomBO();
			if (roomBO.updateRoom(updateRoom) != - 1) {
				ArrayList<Room> listRoom = null;
				try {
					listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listRoom", listRoom);
				response.sendRedirect("/QuanLyNhaTro/landlord/boarding-house?allroom=" + idbdh);
			}
		}
	}

}
