package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.InvoiceDAO;
import model.dao.UserDAO;
import model.bean.Invoice;
import model.bean.User;

public class InvoiceBO {
	InvoiceDAO invoiceDAO = new InvoiceDAO();

	public void insertInvoice(Invoice invoice) {
		try {
			invoiceDAO.insertInvoice(invoice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Invoice> getAllInvoiceByRoomID(String room_id) {
		try {
			return invoiceDAO.getAllInvoiceByRoomID(room_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Invoice getByYearAndMonthAndRoomID(int month, int year, String roomID) {
		try {
			return invoiceDAO.getAllInvoiceByYearAndMonthAndRoomID(month, year, roomID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Invoice getInvoiceByID(String invoice_id) {
		try {
			return invoiceDAO.getInvoiceByID(invoice_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateInvoice(Invoice invoice) {
		try {
			invoiceDAO.updateInvoice(invoice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Invoice> getInvoiceByEmail(String email) {
		try {
			return invoiceDAO.getInvoiceByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
