package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bean.Room;
import model.bo.BoardingHouseBO;


@WebServlet("/room/RoomController")
public class RoomController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			Room newRoom = new Room(roomID, name, idbdh, Integer.parseInt(numberProple), status, Integer.parseInt(currentElectricty), Integer.parseInt(currentWater), Double.parseDouble(price));
			BoardingHouseBO boardingHouseBO = new BoardingHouseBO();
			if (boardingHouseBO.createRoom(newRoom) != -1) {
//				destination = "/home/admin.jsp";
//				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//				rd.forward(request, response);
				System.out.print("Create Room Suscessfully");
			}
		}
	}
	
}
