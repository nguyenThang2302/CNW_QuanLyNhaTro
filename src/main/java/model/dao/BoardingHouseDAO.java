package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import connection.ConnectionDB;
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
	
	public BoardingHouse getBoardingHouseById(UUID userId,UUID boardingHouseId) {
		BoardingHouse boardingHouse=new BoardingHouse();
		
		try {
			ConnectionDB connectionDB=new ConnectionDB();
			Connection connection=connectionDB.connect();
			String sql="SELECT * FROM boarding_house WHERE id=?";
			int count=1;
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(count++, boardingHouseId.toString());
			ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	            boardingHouse.setId(UUID.fromString(rs.getString("id")));
	            boardingHouse.setName(rs.getString("name"));
	            boardingHouse.setAddress(rs.getString("address"));
	            boardingHouse.setElectricityUnitPrice(rs.getDouble("electricity_unit_price"));
	            boardingHouse.setWaterUnitPrice(rs.getDouble("water_unit_price"));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardingHouse;
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

	public List<BoardingHouse> getListBoardingHoseOfTenant(UUID userId) {
		List<BoardingHouse> boardingHouses=new ArrayList<>();
		try {
			ConnectionDB connectionDB=new ConnectionDB();
			Connection connection=connectionDB.connect();
			String sql="SELECT DISTINCT b.* FROM boarding_house b\r\n"
					+ "JOIN rooms r ON r.boarding_house_id = b.id\r\n"
					+ "JOIN users_in_room u ON u.room_id = r.id\r\n"
					+ "WHERE u.user_id =?";
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
	

}
