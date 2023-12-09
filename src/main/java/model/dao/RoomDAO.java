package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.bean.Room;

public class RoomDAO {
	private static ConnectionDB connection = new ConnectionDB();

	public ArrayList<Room> getAllRoomByBDH(String boarding_house_id) throws SQLException {
		Connection con = connection.connect();
		Room room = null;
		ArrayList<Room> result = new ArrayList<Room>();
		String sql = "SELECT * FROM boardinghouse.rooms WHERE boarding_house_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, boarding_house_id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			room = new Room();
			room.setId(rs.getString("id"));
			room.setName(rs.getString("name"));
			room.setNumber_of_people_in_room(rs.getInt("number_of_people_in_room"));
			room.setStatus(rs.getString("status"));
			room.setCurrent_electric_meter(rs.getInt("current_electric_meter"));
			room.setCurrent_water_meter(rs.getInt("current_water_meter"));
			room.setRoom_cost(rs.getDouble("room_cost"));
			result.add(room);
		}
		return result;
	}

	public int deleteRoom(String id) {
		Connection con = connection.connect();
		String sql = "DELETE FROM rooms WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int rowsAffected = pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return rowsAffected;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int createRoom(Room newRoom) {
		ConnectionDB connectionDB = new ConnectionDB();
		Connection con = connectionDB.connect();
		String sql = "INSERT INTO rooms (id, name, boarding_house_id, number_of_people_in_room, status, current_electric_meter, current_water_meter, room_cost)\r\n"
				+ "VALUES\r\n" + "  (?, ?, ?, ?, ?, ?, ?, ?);\r\n" + "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newRoom.getId());
			pstmt.setString(2, newRoom.getName());
			pstmt.setString(3, newRoom.getBoarding_house_id());
			pstmt.setInt(4, newRoom.getNumber_of_people_in_room());
			pstmt.setString(5, newRoom.getStatus());
			pstmt.setInt(6, newRoom.getCurrent_electric_meter());
			pstmt.setInt(7, newRoom.getCurrent_water_meter());
			pstmt.setDouble(8, newRoom.getRoom_cost());
			int rowsAffected = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return rowsAffected;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public Room getRoomByRoomID(String roomID) throws SQLException {
		Connection con = connection.connect();
		Room room = null;
		String sql = "SELECT * FROM boardinghouse.rooms WHERE  id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, roomID);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			room = new Room();
			room.setId(rs.getString("id"));
			room.setName(rs.getString("name"));
			room.setNumber_of_people_in_room(rs.getInt("number_of_people_in_room"));
			room.setStatus(rs.getString("status"));
			room.setCurrent_electric_meter(rs.getInt("current_electric_meter"));
			room.setCurrent_water_meter(rs.getInt("current_water_meter"));
			room.setRoom_cost(rs.getDouble("room_cost"));
		}
//	    System.out.println(room.toString());
		// Close resources
		rs.close();
		pstmt.close();
		con.close();

		return room;
	}

	public List<Double> getWaterAndElectricityUnitPrice(String room_id) {
		Connection con = connection.connect();
		List<Double> result = new ArrayList<Double>();
		String sql = "SELECT electricity_unit_price, water_unit_price FROM rooms JOIN boarding_house\r\n"
				+ "ON rooms.boarding_house_id = boarding_house.id WHERE rooms.id=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, room_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				result.add(Double.parseDouble(rs.getString("electricity_unit_price")));
				result.add(Double.parseDouble(rs.getString("water_unit_price")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	public static void main(String[] args) {
		RoomDAO dao = new RoomDAO();
		List<Double> lists = dao.getWaterAndElectricityUnitPrice("c4b05090-6744-48f6-ada4-90cf642d7b72");
		for(Double d : lists) {
			System.out.println(d);
		}
	}

}
