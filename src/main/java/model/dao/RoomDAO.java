package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
import model.bean.Room;
import model.bean.User;
import model.bean.enums.RoomStatus;

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
	        room.setStatus(RoomStatus.valueOf(rs.getString("status")));
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
	    		+ "VALUES\r\n"
	    		+ "  (?, ?, ?, ?, ?, ?, ?, ?);\r\n"
	    		+ "";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, newRoom.getId());
	        pstmt.setString(2, newRoom.getName());
	        pstmt.setString(3, newRoom.getBoarding_house_id());
	        pstmt.setInt(4, newRoom.getNumber_of_people_in_room());
	        pstmt.setString(5, newRoom.getStatus().toString());
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
	        room.setStatus(RoomStatus.valueOf(rs.getString("status")));
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
	        pstmt.setString(6, updateRoom.getStatus().toString());
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

	public List<Room> getListRoomOfTenant(UUID userId) {
		Connection con = connection.connect();
		List<Room> rooms = new ArrayList<>();
		try {
		String sql = "SELECT r.* FROM boarding_house b\r\n"
				+ "JOIN rooms r ON r.boarding_house_id = b.id\r\n"
				+ "JOIN users_in_room u ON u.room_id = r.id\r\n"
				+ "WHERE u.user_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Room room = new Room();
	        room.setId(rs.getString("id"));
	        room.setName(rs.getString("name"));
	        room.setNumber_of_people_in_room(rs.getInt("number_of_people_in_room"));
	        room.setStatus(RoomStatus.valueOf(rs.getString("status")));
	        room.setCurrent_electric_meter(rs.getInt("current_electric_meter"));
	        room.setCurrent_water_meter(rs.getInt("current_water_meter"));
	        room.setRoom_cost(rs.getDouble("room_cost"));
	        rooms.add(room);
	    }
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		return rooms;
	}
	public int addMemberInRoom(String idUser, String idRoom) {
	    Connection con = connection.connect();
	    String sql = "INSERT INTO users_in_room (user_id, room_id) VALUES (?, ?);";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, idUser);
	        pstmt.setString(2, idRoom);
	        int rowsAffected = pstmt.executeUpdate();
	        
	        pstmt.close();
	        con.close();
	        
	        return rowsAffected;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	public ArrayList<User> getAllMemberInRoom(String idRoom) throws SQLException {
		Connection con = connection.connect();
		String sql = "select users.id, users.full_name, users.email, users.address from users inner join users_in_room on users.id = users_in_room.user_id where users_in_room.room_id = ?";
		User user = null;
		ArrayList<User> result = new ArrayList<User>();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, idRoom);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(UUID.fromString(rs.getString("id")));
				user.setAddress(rs.getString("address"));
				user.setFullName(rs.getString("full_name"));
				user.setEmail(rs.getString("email"));
				result.add(user);
			}
		} finally {
			con.close();
		}
		return result;
	}
}
