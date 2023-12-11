package controller.tenant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Invoice;
import model.bean.Room;
import model.bean.User;
import model.bean.enums.Role;
import model.bo.InvoiceBO;
import model.bo.RoomBO;

@WebServlet("/tenant/room")
public class RoomController extends HttpServlet {
	RoomBO roomBO = new RoomBO();
	InvoiceBO invoiceBO = new InvoiceBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.TENANT)) {
			if (request.getParameter("view_invoice")!=null) {
				String email = user.getEmail();
				List<Invoice> invoiceList = invoiceBO.getInvoiceByEmail(email);
				request.setAttribute("invoiceList", invoiceList);
				String destination = "/tenant/invoice/invoiceList.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} else {
				System.out.print("sdsd");
				List<Room> rooms = roomBO.getListRoomOfTenant(user.getId());
				request.setAttribute("rooms", rooms);
				String destination = "/tenant/room/roomList.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		} else {
			response.sendRedirect("../404.jsp");
		}
	}
}
