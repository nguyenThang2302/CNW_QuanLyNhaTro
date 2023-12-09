package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
