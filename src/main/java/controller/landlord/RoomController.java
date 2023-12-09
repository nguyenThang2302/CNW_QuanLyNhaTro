package controller.landlord;

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

import model.bean.Room;
import model.bean.User;
import model.bean.enums.Role;
import model.bean.enums.RoomStatus;
import model.bo.BoardingHouseBO;
import model.bo.RoomBO;

@WebServlet("/landlord/room")
public class RoomController extends HttpServlet{
	private RoomBO roomBO=new RoomBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
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
			destination = "/landlord/room/roomList.jsp";
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
				response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + request.getParameter("idbdh"));
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
			destination = "/landlord/room/update.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}else if (request.getParameter("detailroom") != null) {
			String destination = null;
			RoomBO roomBO = new RoomBO();
			ArrayList<User> listUserInRoom = null;
			try {
				listUserInRoom = roomBO.getAllMemberInRoom(request.getParameter("detailroom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("listUserInRoom", listUserInRoom);
			destination = "/landlord/room/detail.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		}else {
			response.sendRedirect("../404.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
		if (request.getParameter("create_room") != null) {
			String destination = null;
			String roomID = UUID.randomUUID().toString();
			String idbdh = request.getParameter("idbdh");
			String name = request.getParameter("name");
			String numberProple = request.getParameter("number_people");
			String currentElectricty = request.getParameter("electricty");
			String currentWater = request.getParameter("water");
			String price = request.getParameter("price");
			String status = "empty";
			Room newRoom = new Room(roomID, name, idbdh, Integer.parseInt(numberProple),RoomStatus.valueOf(status),
					Integer.parseInt(currentElectricty), Integer.parseInt(currentWater), Double.parseDouble(price));
			BoardingHouseBO boardingHouseBO = new BoardingHouseBO();
			if (roomBO.createRoom(newRoom) != -1) {
				RoomBO roomBO = new RoomBO();
				ArrayList<Room> listRoom = null;
				try {
					listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listRoom", listRoom);
				response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + idbdh);
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
			Room updateRoom = new Room(idroom, name, idbdh, Integer.parseInt(number_people), RoomStatus.valueOf(status), Integer.parseInt(electricty), Integer.parseInt(water), Double.parseDouble(price));
			RoomBO roomBO = new RoomBO();
			if (roomBO.updateRoom(updateRoom) != - 1) {
				ArrayList<Room> listRoom = null;
				try {
					listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listRoom", listRoom);
				response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + idbdh);
			}
		}}else {
			response.sendRedirect("../404.jsp");
		}

	}
}
