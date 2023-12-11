package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
import model.bean.Invoice;
import model.bean.Room;
import model.bean.User;
import model.bean.enums.InvoiceStatus;
import model.bean.enums.Role;
import model.bo.RoomBO;

public class InvoiceDAO {
	private static ConnectionDB connection = new ConnectionDB();

	public void insertInvoice(Invoice invoice) throws SQLException {

		Connection con = connection.connect();
		String sql = "INSERT INTO invoice (id, date, room_id, previous_electric_meter, current_electric_meter, electricity_cost, "
				+ "previous_water_meter, current_water_meter, water_cost, additional_cost, total_cost, room_cost, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		// Generate a new UUID for the invoice
		invoice.setId(UUID.randomUUID());

		// Set values for the prepared statement
		pstmt.setString(1, invoice.getId().toString());
		pstmt.setDate(2, new java.sql.Date(invoice.getDate().getTime())); // Assuming invoice.getDate() returns a
																			// java.util.Date
		pstmt.setObject(3, invoice.getRoom().getId()); // Assuming RoomInfo has an id property
		pstmt.setDouble(4, invoice.getPreviousElectricMeter());
		pstmt.setDouble(5, invoice.getCurrentElectricMeter());
		pstmt.setDouble(6, invoice.getElectricityCost());
		pstmt.setDouble(7, invoice.getPreviousWaterMeter());
		pstmt.setDouble(8, invoice.getCurrentWaterMeter());
		pstmt.setDouble(9, invoice.getWaterCost());
		pstmt.setDouble(10, invoice.getAdditionalCost());
		pstmt.setDouble(11, invoice.getTotalCost());
		pstmt.setDouble(12, invoice.getRoomCost());
		pstmt.setString(13, invoice.getStatus().toString());

		// Execute the insert statement
		pstmt.executeUpdate();

		// Close resources
		pstmt.close();
		con.close();
	}

	public List<Invoice> getAllInvoiceByRoomID(String room_id) throws SQLException {
		Connection con = connection.connect();
		List<Invoice> result = new ArrayList<>();
		String sql = "SELECT * FROM invoice where room_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, room_id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Invoice invoice = new Invoice();
			invoice.setId(UUID.fromString(rs.getString("id")));
			invoice.setDate(rs.getDate("date"));

			// Assuming there is a method to retrieve RoomInfo by id
			RoomBO roomBO = new RoomBO();

			Room roomInfo = roomBO.getRoomByRoomID(rs.getObject("room_id").toString());
			invoice.setRoom(roomInfo);
			invoice.setPreviousElectricMeter(rs.getDouble("previous_electric_meter"));
			invoice.setCurrentElectricMeter(rs.getDouble("current_electric_meter"));
			invoice.setElectricityCost(rs.getDouble("electricity_cost"));
			invoice.setPreviousWaterMeter(rs.getDouble("previous_water_meter"));
			invoice.setCurrentWaterMeter(rs.getDouble("current_water_meter"));
			invoice.setWaterCost(rs.getDouble("water_cost"));
			invoice.setAdditionalCost(rs.getDouble("additional_cost"));
			invoice.setTotalCost(rs.getDouble("total_cost"));
			invoice.setRoomCost(rs.getDouble("room_cost"));
			invoice.setStatus(InvoiceStatus.valueOf(rs.getString("status")));

			result.add(invoice);
		}

		// Close resources
		rs.close();
		pstmt.close();
		con.close();

		return result;
	}

	public Invoice getAllInvoiceByYearAndMonthAndRoomID(int month, int year, String roomID) throws SQLException {
		Connection con = connection.connect();
		Invoice invoice = new Invoice();
		String sql = "SELECT * FROM invoice where month(date)=? and year(date) = ? and room_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, month);
		pstmt.setInt(2, year);
		pstmt.setString(3, roomID);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			invoice.setId(UUID.fromString(rs.getString("id")));
			invoice.setDate(rs.getDate("date"));

			// Assuming there is a method to retrieve RoomInfo by id
			RoomBO roomBO = new RoomBO();

			Room roomInfo = roomBO.getRoomByRoomID(rs.getObject("room_id").toString());
			invoice.setRoom(roomInfo);
			invoice.setPreviousElectricMeter(rs.getDouble("previous_electric_meter"));
			invoice.setCurrentElectricMeter(rs.getDouble("current_electric_meter"));
			invoice.setElectricityCost(rs.getDouble("electricity_cost"));
			invoice.setPreviousWaterMeter(rs.getDouble("previous_water_meter"));
			invoice.setCurrentWaterMeter(rs.getDouble("current_water_meter"));
			invoice.setWaterCost(rs.getDouble("water_cost"));
			invoice.setAdditionalCost(rs.getDouble("additional_cost"));
			invoice.setTotalCost(rs.getDouble("total_cost"));
			invoice.setRoomCost(rs.getDouble("room_cost"));
			invoice.setRoomCost(rs.getDouble("room_cost"));
			invoice.setStatus(InvoiceStatus.valueOf(rs.getString("status")));
		}

		// Close resources
		rs.close();
		pstmt.close();
		con.close();

		return invoice;
	}

	public Invoice getInvoiceByID(String invoice_id) throws SQLException {
		Connection con = connection.connect();
		Invoice invoice = new Invoice();
		String sql = "SELECT * FROM invoice where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, invoice_id);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			invoice.setId(UUID.fromString(rs.getString("id")));
			invoice.setDate(rs.getDate("date"));

			// Assuming there is a method to retrieve RoomInfo by id
			RoomBO roomBO = new RoomBO();

			Room roomInfo = roomBO.getRoomByRoomID(rs.getObject("room_id").toString());
			invoice.setRoom(roomInfo);
			invoice.setPreviousElectricMeter(rs.getDouble("previous_electric_meter"));
			invoice.setCurrentElectricMeter(rs.getDouble("current_electric_meter"));
			invoice.setElectricityCost(rs.getDouble("electricity_cost"));
			invoice.setPreviousWaterMeter(rs.getDouble("previous_water_meter"));
			invoice.setCurrentWaterMeter(rs.getDouble("current_water_meter"));
			invoice.setWaterCost(rs.getDouble("water_cost"));
			invoice.setAdditionalCost(rs.getDouble("additional_cost"));
			invoice.setTotalCost(rs.getDouble("total_cost"));
			invoice.setRoomCost(rs.getDouble("room_cost"));
			invoice.setStatus(InvoiceStatus.valueOf(rs.getString("status")));
		}

		// Close resources
		rs.close();
		pstmt.close();
		con.close();

		return invoice;
	}

	public void updateInvoice(Invoice invoice) throws SQLException {

		Connection con = connection.connect();
		String sql = "UPDATE invoice SET previous_electric_meter=?, current_electric_meter=?, "
				+ "electricity_cost=?, previous_water_meter=?, current_water_meter=?, water_cost=?, additional_cost=?, "
				+ "total_cost=?, room_cost=?, status=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// Set values for the prepared statement
		pstmt.setDouble(1, invoice.getPreviousElectricMeter());
		pstmt.setDouble(2, invoice.getCurrentElectricMeter());
		pstmt.setDouble(3, invoice.getElectricityCost());
		pstmt.setDouble(4, invoice.getPreviousWaterMeter());
		pstmt.setDouble(5, invoice.getCurrentWaterMeter());
		pstmt.setDouble(6, invoice.getWaterCost());
		pstmt.setDouble(7, invoice.getAdditionalCost());
		pstmt.setDouble(8, invoice.getTotalCost());
		pstmt.setDouble(9, invoice.getRoomCost());
		pstmt.setString(10, invoice.getStatus().toString());
		pstmt.setString(11, invoice.getId().toString());

		// Execute the update statement
		pstmt.executeUpdate();

		// Close resources
		pstmt.close();
		con.close();
	}

	public List<Invoice> getInvoiceByEmail(String email) throws SQLException {
		Connection con = connection.connect();
		List<Invoice>result = new ArrayList<Invoice>();
		String sql = "SELECT i.* FROM users INNER JOIN boarding_house \n" + "ON users.id = boarding_house.user_id\n"
				+ "JOIN rooms ON boarding_house.id = rooms.boarding_house_id\n"
				+ "INNER JOIN invoice AS i ON i.room_id = rooms.id \n" + "WHERE users.email=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Invoice invoice = new Invoice();
			invoice.setId(UUID.fromString(rs.getString("id")));
			invoice.setDate(rs.getDate("date"));

			// Assuming there is a method to retrieve RoomInfo by id
			RoomBO roomBO = new RoomBO();

			Room roomInfo = roomBO.getRoomByRoomID(rs.getObject("room_id").toString());
			invoice.setRoom(roomInfo);
			invoice.setPreviousElectricMeter(rs.getDouble("previous_electric_meter"));
			invoice.setCurrentElectricMeter(rs.getDouble("current_electric_meter"));
			invoice.setElectricityCost(rs.getDouble("electricity_cost"));
			invoice.setPreviousWaterMeter(rs.getDouble("previous_water_meter"));
			invoice.setCurrentWaterMeter(rs.getDouble("current_water_meter"));
			invoice.setWaterCost(rs.getDouble("water_cost"));
			invoice.setAdditionalCost(rs.getDouble("additional_cost"));
			invoice.setTotalCost(rs.getDouble("total_cost"));
			invoice.setRoomCost(rs.getDouble("room_cost"));
			invoice.setStatus(InvoiceStatus.valueOf(rs.getString("status")));
			result.add(invoice);
		}

		// Close resources
		rs.close();
		pstmt.close();
		con.close();

		return result;
	}

}
