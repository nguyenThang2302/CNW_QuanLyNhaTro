package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
