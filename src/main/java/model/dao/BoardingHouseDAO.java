package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
import model.bean.Account;
import model.bean.BoardingHouse;
import model.bean.Room;

public class BoardingHouseDAO {

	public boolean create(BoardingHouse boardingHouse, UUID userId) {
		int i=0;
		try {
			ConnectionDB connectionDB=new ConnectionDB();
			Connection connection=connectionDB.connect();
			String sql="INSERT INTO `boarding_house` (`id`, `address`, `name`, `user_id`, `electricity_unit_price`, `water_unit_price`) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			int count=1;
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(count++, UUID.randomUUID().toString());
			pstm.setString(count++, boardingHouse.getAddress());
			pstm.setString(count++, boardingHouse.getName());
			pstm.setString(count++, userId.toString());
			pstm.setDouble(count++, boardingHouse.getElectricityUnitPrice());
			pstm.setDouble(count++, boardingHouse.getWaterUnitPrice());
			i=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i >0 ? true : false;
	}

	public List<BoardingHouse> getListBoardingHouse(UUID userId) {
		List<BoardingHouse> boardingHouses=new ArrayList<>();
		
		try {
			ConnectionDB connectionDB=new ConnectionDB();
			Connection connection=connectionDB.connect();
			String sql="SELECT * FROM boarding_house WHERE user_id=?";
			int count=1;
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(count++, userId.toString());
			ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	        	BoardingHouse boardingHouse = new BoardingHouse();
	            boardingHouse.setId(UUID.fromString(rs.getString("id")));
	            boardingHouse.setName(rs.getString("name"));
	            boardingHouse.setAddress(rs.getString("address"));
	            boardingHouse.setElectricityUnitPrice(rs.getDouble("electricity_unit_price"));
	            boardingHouse.setWaterUnitPrice(rs.getDouble("water_unit_price"));
	            boardingHouses.add(boardingHouse);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardingHouses;
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
}
