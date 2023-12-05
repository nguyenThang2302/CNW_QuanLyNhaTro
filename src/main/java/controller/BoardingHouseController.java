package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BoardingHouse;
import model.bo.BoardingHouseBO;

@WebServlet("/boarding-house")
public class BoardingHouseController extends HttpServlet{
	BoardingHouseBO boardingHouseBO=new BoardingHouseBO();
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("create")!=null) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String electricity = request.getParameter("electricty");
			String water = request.getParameter("water");
			
			BoardingHouse boardingHouse=new BoardingHouse();
			boardingHouse.setAddress(address);
			boardingHouse.setName(name);
			boardingHouse.setElectricityUnitPrice(Double.parseDouble(electricity));
			boardingHouse.setWaterUnitPrice(Double.parseDouble(water));
			
			if ( boardingHouseBO.create(boardingHouse, UUID.fromString("34fbcd62-2a15-4e37-8dbf-cbb19e57b8e2"))) {
				request.setAttribute("boardingHouse", boardingHouse);
			    request.getRequestDispatcher("/boardingHouseList.jsp").forward(request, response);
			}
		}
	}
}
