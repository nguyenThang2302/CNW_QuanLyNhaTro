package controller.landlord;

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

import model.bean.BoardingHouse;
import model.bean.Room;
import model.bean.User;
import model.bo.BoardingHouseBO;
import model.bo.RoomBO;

@WebServlet("/landlord/boarding-house")
public class BoardingHouseController extends HttpServlet{
	BoardingHouseBO boardingHouseBO=new BoardingHouseBO();
	RoomBO roomBO=new RoomBO();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id")!=null) {
			UUID boardingHouseId=UUID.fromString(request.getParameter("id"));
			BoardingHouse boardingHouse=boardingHouseBO.getBoardingHouseById(null, boardingHouseId);
			request.setAttribute("boardingHouse", boardingHouse);
		    request.getRequestDispatcher("/landlord/boarding-house/update.jsp").forward(request, response);
		}else if (request.getParameter("allroom") != null) {
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
		}else if (request.getParameter("deleteroom") != null) {
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
		}else {
			List<BoardingHouse> boardingHouses=boardingHouseBO.getListBoardingHouse( UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"));
			request.setAttribute("boardingHouses", boardingHouses);
		    request.getRequestDispatcher("/landlord/boarding-house/boardingHouseList.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("create")!=null) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String electricity = request.getParameter("electricity");
			String water = request.getParameter("water");
			
			BoardingHouse boardingHouse=new BoardingHouse();
			boardingHouse.setAddress(address);
			boardingHouse.setName(name);
			boardingHouse.setElectricityUnitPrice(Double.parseDouble(electricity));
			boardingHouse.setWaterUnitPrice(Double.parseDouble(water));
			
			if ( boardingHouseBO.create(boardingHouse, UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"))) {
				List<BoardingHouse> boardingHouses=boardingHouseBO.getListBoardingHouse( UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"));
				request.setAttribute("boardingHouses", boardingHouses);
				 request.getRequestDispatcher("/landlord/boarding-house/boardingHouseList.jsp").forward(request, response);
			}
		}
		if (request.getParameter("update")!=null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String electricity = request.getParameter("electricity");
			String water = request.getParameter("water");
			BoardingHouse boardingHouse=new BoardingHouse();
			boardingHouse.setId(UUID.fromString(id));
			boardingHouse.setAddress(address);
			boardingHouse.setName(name);
			boardingHouse.setElectricityUnitPrice(Double.parseDouble(electricity));
			boardingHouse.setWaterUnitPrice(Double.parseDouble(water));
			
			if ( boardingHouseBO.create(boardingHouse, UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"))) {
				List<BoardingHouse> boardingHouses=boardingHouseBO.getListBoardingHouse( UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"));
				request.setAttribute("boardingHouses", boardingHouses);
				 request.getRequestDispatcher("/landlord/boarding-house/boardingHouseList.jsp").forward(request, response);
			}
		}else if (request.getParameter("create_room") != null) {
			String destination = null;
			String roomID = UUID.randomUUID().toString();
			User user = (User) request.getSession().getAttribute("user");
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
			if (roomBO.createRoom(newRoom) != -1) {
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
		}
	}
}
