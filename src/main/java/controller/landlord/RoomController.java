package controller.landlord;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Invoice;
import model.bean.Room;
import model.bean.User;
import model.bean.enums.InvoiceStatus;
import model.bean.enums.Role;
import model.bean.enums.RoomStatus;
import model.bo.BoardingHouseBO;
import model.bo.InvoiceBO;
import model.bo.RoomBO;

@WebServlet("/landlord/room")
public class RoomController extends HttpServlet {
	private RoomBO roomBO = new RoomBO();
	private InvoiceBO invoiceBO = new InvoiceBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole().equals(Role.LANDLORD)) {
			if (request.getParameter("allroom") != null || request.getParameter("status") != null) {
				String destination = null;
				RoomBO roomBO = new RoomBO();
				ArrayList<Room> listRoom = null;
				String bdhId = request.getParameter("allroom");
				if (bdhId != null) {
					request.getSession().setAttribute("bdhId", bdhId);
				}
				if ((String) request.getParameter("status") != null) {
					request.getSession().setAttribute("status", (String) request.getParameter("status"));
					String boarding_house_id = (String) request.getSession().getAttribute("bdhId");
					response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + boarding_house_id);

				} else {
					try {
						listRoom = roomBO.getAllRoomByBDH(bdhId);
					} catch (SQLException e) {
						e.printStackTrace();
					}

					request.setAttribute("listRoom", listRoom);
					destination = "/landlord/room/roomList.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
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
			} else if (request.getParameter("detailroom") != null) {
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
			} else if (request.getParameter("view_invoice") != null) {
				String room_id = request.getParameter("view_invoice");
				List<Invoice> invoiceList = invoiceBO.getAllInvoiceByRoomID(room_id);
				request.setAttribute("invoiceList", invoiceList);
				request.getRequestDispatcher("/landlord/invoice/InvoiceList.jsp").forward(request, response);
			} else if (request.getParameter("add_new_invoice") != null) {
				Calendar calendar = Calendar.getInstance();
				Invoice currentInvoice = invoiceBO.getByYearAndMonthAndRoomID(calendar.get(Calendar.MONTH) + 1,
						calendar.get(Calendar.YEAR), (String) request.getParameter("add_new_invoice"));
				if (currentInvoice.getId() != null) {
					String message = "Invoice this month already created";
					response.sendRedirect(request.getRequestURI() + "?status=" + URLEncoder.encode(message, "UTF-8"));
				} else {
					request.setAttribute("room_id", (String) request.getParameter("add_new_invoice"));
					request.getRequestDispatcher("/landlord/invoice/create.jsp").forward(request, response);

				}
			} else if (request.getParameter("update_invoice") != null) {
				String invoice_id = request.getParameter("update_invoice");
				Invoice invoice = null;
				invoice = invoiceBO.getInvoiceByID(invoice_id);
				request.setAttribute("invoice", invoice);
				request.getRequestDispatcher("/landlord/invoice/update.jsp").forward(request, response);
			}
		} else {
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
				Room newRoom = new Room(roomID, name, idbdh, Integer.parseInt(numberProple), RoomStatus.valueOf(status),
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
				Room updateRoom = new Room(idroom, name, idbdh, Integer.parseInt(number_people),
						RoomStatus.valueOf(status), Integer.parseInt(electricty), Integer.parseInt(water),
						Double.parseDouble(price));
				RoomBO roomBO = new RoomBO();
				if (roomBO.updateRoom(updateRoom) != -1) {
					ArrayList<Room> listRoom = null;
					try {
						listRoom = roomBO.getAllRoomByBDH(request.getParameter("allroom"));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					request.setAttribute("listRoom", listRoom);
					response.sendRedirect("/QuanLyNhaTro/landlord/room?allroom=" + idbdh);
				}
			} else if (request.getParameter("add_new_invoice") != null) {
				String room_id = request.getParameter("room_id");
				Calendar calendar = Calendar.getInstance();
				Invoice currentInvoice = invoiceBO.getByYearAndMonthAndRoomID(calendar.get(Calendar.MONTH) + 1,
						calendar.get(Calendar.YEAR), room_id);
				if (currentInvoice.getId() != null) {
					request.setAttribute("status", "Invoice this month already created");
					response.sendRedirect("/QuanLyNhaTro/landlord/boarding-house?allroom=" + room_id);

				} else {
					Invoice previousInvoice = invoiceBO.getByYearAndMonthAndRoomID(calendar.get(Calendar.MONTH),
							calendar.get(Calendar.YEAR), room_id);
					String additionalCost = request.getParameter("additionalCost");
					String roomCost = request.getParameter("roomCost");
					String currentElectricMeter = request.getParameter("currentElectricMeter");
					String currentWaterMeter = request.getParameter("currentWaterMeter");
					List<Double> waterAndElectricUnitPrice = roomBO.getWaterAndElectricityUnitPrice(room_id);
					Double waterUnitPrice = waterAndElectricUnitPrice.get(1);
					Double electricUnitPrice = waterAndElectricUnitPrice.get(0);
					double previousElectricMeter = previousInvoice.getCurrentElectricMeter().doubleValue();
					double previousWaterMeter = previousInvoice.getCurrentWaterMeter().doubleValue();
					double electricityCost = (Double.parseDouble(currentElectricMeter) - previousElectricMeter)
							* electricUnitPrice;
					double waterCost = (Double.parseDouble(currentWaterMeter) - previousWaterMeter) * waterUnitPrice;
					double totalCost = Double.parseDouble(roomCost) + electricityCost + waterCost
							+ Double.parseDouble(additionalCost);
					Room room = roomBO.getRoomByRoomID(room_id);
					UUID id = UUID.randomUUID();
					Date d = new Date();
					InvoiceStatus status = InvoiceStatus.valueOf(request.getParameter("status"));
					Invoice invoice = new Invoice(id, d, room, previousElectricMeter,
							Double.parseDouble(currentElectricMeter), electricityCost, previousWaterMeter,
							Double.parseDouble(currentWaterMeter), waterCost, Double.parseDouble(additionalCost),
							totalCost, Double.parseDouble(roomCost), status);
					InvoiceBO invoiceBO = new InvoiceBO();
					invoiceBO.insertInvoice(invoice);
					response.sendRedirect("/QuanLyNhaTro/landlord/room?view_invoice=" + room_id);

				}
			} else if (request.getParameter("updateInvoice") != null) {
				String invoice_id = request.getParameter("room_id");
				Invoice invoice = invoiceBO.getInvoiceByID(invoice_id);
				String room_id = invoice.getRoom().getId();
				Calendar calendar = Calendar.getInstance();
				Invoice previousInvoice = invoiceBO.getByYearAndMonthAndRoomID(calendar.get(Calendar.MONTH),
						calendar.get(Calendar.YEAR), room_id);
				String additionalCost = request.getParameter("additionalCost");
				String roomCost = request.getParameter("roomCost");
				String currentElectricMeter = request.getParameter("currentElectricMeter");
				String currentWaterMeter = request.getParameter("currentWaterMeter");
				List<Double> waterAndElectricUnitPrice = roomBO.getWaterAndElectricityUnitPrice(room_id);
				Double waterUnitPrice = waterAndElectricUnitPrice.get(1);
				Double electricUnitPrice = waterAndElectricUnitPrice.get(0);
				double previousElectricMeter = previousInvoice.getCurrentElectricMeter().doubleValue();
				double previousWaterMeter = previousInvoice.getCurrentWaterMeter().doubleValue();
				double electricityCost = (Double.parseDouble(currentElectricMeter) - previousElectricMeter)
						* electricUnitPrice;
				double waterCost = (Double.parseDouble(currentWaterMeter) - previousWaterMeter) * waterUnitPrice;
				double totalCost = Double.parseDouble(roomCost) + electricityCost + waterCost
						+ Double.parseDouble(additionalCost);
				Room room = roomBO.getRoomByRoomID(room_id);
				UUID id = UUID.fromString(invoice_id);
				Date d = new Date();
				InvoiceStatus status = InvoiceStatus.valueOf(request.getParameter("status"));
				Invoice invoiceUpdate = new Invoice(id, d, room, previousElectricMeter,
						Double.parseDouble(currentElectricMeter), electricityCost, previousWaterMeter,
						Double.parseDouble(currentWaterMeter), waterCost, Double.parseDouble(additionalCost), totalCost,
						Double.parseDouble(roomCost), status);
				InvoiceBO invoiceBO = new InvoiceBO();
				invoiceBO.updateInvoice(invoiceUpdate);
				response.sendRedirect("/QuanLyNhaTro/landlord/room?view_invoice=" + room_id);
			}
		}

		else {
			response.sendRedirect("../404.jsp");
		}

	}
}
