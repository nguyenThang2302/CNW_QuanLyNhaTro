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
	
	public Room getRoomByUUID(String uuid) throws SQLException {
		Connection con = connection.connect();
		String sql = "SELECT * FROM rooms WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		Room room = null;
		pstmt.setString(1, uuid);
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
	    }
		return room;
	}
	
	public int updateRoom(Room updateRoom) {
	    Connection con = connection.connect();
	    String sql = "UPDATE rooms SET name = ?, number_of_people_in_room = ?, current_electric_meter = ?, current_water_meter = ?, room_cost = ?, status = ? WHERE id = ?";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, updateRoom.getName());
	        pstmt.setInt(2, updateRoom.getNumber_of_people_in_room());
	        pstmt.setInt(3, updateRoom.getCurrent_electric_meter());
	        pstmt.setInt(4, updateRoom.getCurrent_water_meter());
	        pstmt.setDouble(5, updateRoom.getRoom_cost());
	        pstmt.setString(6, updateRoom.getStatus());
	        pstmt.setString(7, updateRoom.getId());
	        
	        int rowsAffected = pstmt.executeUpdate();
	        
	        pstmt.close();
	        con.close();
	        
	        return rowsAffected;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
}
