package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.bean.Room;
import model.bean.User;
import model.dao.RoomDAO;

public class RoomBO {
	RoomDAO roomDAO = new RoomDAO();
	public ArrayList<Room> getAllRoomByBDH(String boarding_house_id) throws SQLException {
		return roomDAO.getAllRoomByBDH(boarding_house_id);
	}
	public int deleteRoom(String id) {
		return roomDAO.deleteRoom(id);
	}
	public int createRoom(Room newRoom) {
		return roomDAO.createRoom(newRoom);
	}
	public Room getRoomByUUID(String uuid) throws SQLException {
		return roomDAO.getRoomByUUID(uuid);
	}
	public int updateRoom(Room updateRoom) {
		return roomDAO.updateRoom(updateRoom);
	}
	public List<Room> getListRoomOfTenant(UUID userId) {
		return roomDAO.getListRoomOfTenant(userId);
	}
	public int addMemberInRoom(String userID, String idroom) {
		return roomDAO.addMemberInRoom(userID, idroom);
	}
	public ArrayList<User> getAllMemberInRoom(String idRoom) throws SQLException {
		
		return roomDAO.getAllMemberInRoom(idRoom);
	}
	public Room getRoomByRoomID(String name) {
		try {
			return roomDAO.getRoomByRoomID(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Double> getWaterAndElectricityUnitPrice(String room_id) {
		return roomDAO.getWaterAndElectricityUnitPrice(room_id);
	}

}
