package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Room;
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
}
